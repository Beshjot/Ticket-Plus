package com.besh.ticketplus.controller;

import com.besh.ticketplus.domain.Cart;
import com.besh.ticketplus.domain.Movie;
import com.besh.ticketplus.domain.News;
import com.besh.ticketplus.service.CartService;
import com.besh.ticketplus.service.MovieService;
import com.besh.ticketplus.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController
{
    @Autowired
    private MovieService service;
    @Autowired
    private CartService cartService;
    @Autowired
    private NewsService newsService;
    @GetMapping("/")
    public String homepage(Model model)
    {
        System.out.println("* MovieController.findAll:");
        List<Movie> allMovies = service.findAll();
        model.addAttribute("entries", allMovies);
        return "index";
    }
    @GetMapping("/search")
    public String search(@RequestParam(name="search", required=true)long id, Model model)
    {
        System.out.println("* MovieController.findAll:");
        Movie movie = service.findById(id);
        Cart cart = cartService.findById(id);
        Long quantity = 0L;
        if (cart != null)
        {
            quantity = cart.getQuantity();
        }
        model.addAttribute("title", movie.getTitle());
        model.addAttribute("movie", movie);
        model.addAttribute("quantity", quantity);
        return "search";
    }
    @GetMapping("/view")
    public String view(@RequestParam(name="id", required=true) long id, Model model)
    {
        Movie movie = service.findById(id);
        Cart cart = cartService.findById(id);
        Long quantity = 0L;
        if (cart != null)
        {
            quantity = cart.getQuantity();
        }
        model.addAttribute("title", movie.getTitle());
        model.addAttribute("movie", movie);
        model.addAttribute("quantity", quantity);

        return "view";
    }
    @GetMapping("/checkout")
    public String checkout(@RequestParam(name="price", required=true) double price,
                           @RequestParam(name="coupon", required = false) String coupon, Model model)
    {
        if(coupon.equalsIgnoreCase("SITE"))
        {
            price = price * 0.80;
            model.addAttribute("coupon","Applied 20% discount!");
        }
        else if(coupon=="")
        {
            model.addAttribute("coupon","No Coupon Applied!");
        }
        else
        {
            model.addAttribute("coupon","Invalid Coupon!");
        }
        model.addAttribute("total", price);
        return "checkout";
    }
    @RequestMapping(value = "/news", method={RequestMethod.POST,RequestMethod.GET})
    public String news(@RequestParam(name="heading", required=false) String title,
                       @RequestParam(name="details", required=false) String details,
                       Model model)
    {
        System.out.println("* NewsController.findAll:");
        List<News> allNews = newsService.findAll();
        model.addAttribute("entries", allNews);
        if(title!=null && details!=null)
        {
            News news = new News(allNews.size() + 1,title,details);
            newsService.add(news);
        }
        return "news";
    }
    @GetMapping("/cart")
    public String cartAdd(@RequestParam(name="add", required=false) String add,
                          @RequestParam(name="del", required=false) String del,
                          @RequestParam(name="movieid", required=false) String movieid,
                          @RequestParam(name="quantity", required=false) String quantity, Model model)
    {
        if(add !=null)
        {
            Movie movie = service.findById(Long.parseLong(add));
            if(Long.parseLong(quantity) > 0)
            {
                Cart cart = new Cart(movie.getMovieId(),movie.getTitle(),movie.getImage(),Long.parseLong(quantity));
                cartService.add(cart);
            }
        }
        else if(del !=null)
        {
            Movie movie = service.findById(Long.parseLong(del));
            cartService.delete(movie.getMovieId());
        }
        else if(movieid !=null && quantity !=null)
        {
            Movie movie = service.findById(Long.parseLong(movieid));
            Cart cart = new Cart(movie.getMovieId(),movie.getTitle(),movie.getImage(),Long.parseLong(quantity));
            cartService.update(cart);
        }
        System.out.println("* CartController.findAll:");
        List<Cart> carts = cartService.findAll();
        float total = 0;
        for (Cart cart:carts)
        {
            total = total + cart.getPrice();
        }
        model.addAttribute("entries", carts);
        model.addAttribute("total", total);
        return "cart";
    }

}