package com.besh.ticketplus.controller;

import com.besh.ticketplus.domain.Cart;
import com.besh.ticketplus.domain.Movie;
import com.besh.ticketplus.service.CartService;
import com.besh.ticketplus.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController
{
    @Autowired
    private MovieService service;
    @Autowired
    private CartService cartService;
    @GetMapping("/")
    public String homepage(Model model)
    {
        System.out.println("* MovieController.findAll:");
        List<Movie> allMovies = service.findAll();
        model.addAttribute("entries", allMovies);
        return "index";
    }
    @GetMapping("/search")
    public String search(Model model)
    {
        System.out.println("* MovieController.findAll:");
        List<Movie> allMovies = service.findAll();
        model.addAttribute("entries", allMovies);
        return "index";
    }
    @GetMapping("/view")
    public String view(@RequestParam(name="id", required=true) long id, Model model)
    {
        Movie movie = service.findById(id);
        model.addAttribute("title", movie.getTitle());
        model.addAttribute("movie", movie);
        return "view";
    }
    @GetMapping("/news")
    public String news(Model model)
    {
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
            Cart cart = new Cart(movie.getMovieId(),movie.getTitle(),movie.getImage(),1);
            cartService.add(cart);
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
        model.addAttribute("entries", carts);
        return "cart";
    }
}