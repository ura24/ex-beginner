package com.example.exbeginner.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exbeginner.domain.Item;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/exam06")
public class ShoppingCartController {
    
    @Autowired
    private HttpSession session;
    @Autowired
    private ServletContext application;

    /**
     * 「商品⼀覧＆ショッピングカート⼀覧画⾯」を表⽰する
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        // applicationスコープに商品⼀覧が存在しなければ商品⼀覧を作成し格納する
        List<Item> itemList = (LinkedList<Item>) application.getAttribute("itemList");
        if (itemList == null) {
            itemList = new LinkedList<Item>();
            Item item1 = new Item("手帳ノート", 1000);
            Item item2 = new Item("文房具セット", 1500);
            Item item3 = new Item("ファイル", 2000);
            itemList.add(item1);
            itemList.add(item2);
            itemList.add(item3);
            application.setAttribute("itemList", itemList);
        }

        // sessionスコープ内にカートの内容が存在しなければ空のリストを作成し格納する
        List<Item> cartList = (LinkedList<Item>) session.getAttribute("cartList");
        if (cartList == null) {
            cartList = new LinkedList<Item>();
            session.setAttribute("cartList", cartList);
        }

        // requestスコープに合計金額を格納する
        int sumPrice = 0;
        for (Item item: cartList) {
            sumPrice += item.getPrice();
        }
        model.addAttribute("sumPrice", sumPrice);

        return "item-and-cart";
    }

    @GetMapping("/inCart")
    public String inCart(int index) {
        List<Item> itemList = (LinkedList<Item>) application.getAttribute("itemList");
        Item item = itemList.get(index);

        List<Item> cartList = (LinkedList<Item>) session.getAttribute("cartList");
        cartList.add(item);
        session.setAttribute("cartList", cartList);

        return "redirect:/exam06";
    }

    @GetMapping("/delete")
    public String delete(int index) {
        List<Item> cartList = (LinkedList<Item>) session.getAttribute("cartList");
        cartList.remove(index);
        session.setAttribute("cartList", cartList);

        return "redirect:/exam06";
    }
}
