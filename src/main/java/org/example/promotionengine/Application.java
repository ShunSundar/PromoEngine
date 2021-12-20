package org.example.promotionengine;

import org.example.promotionengine.algorithm.discount.AmountBasedDiscountCalculator;
import org.example.promotionengine.algorithm.discount.DiscountCalculatorFactory;
import org.example.promotionengine.algorithm.discount.DiscountCalculatorFactoryImpl;
import org.example.promotionengine.algorithm.discount.RateBasedDiscountCalculator;
import org.example.promotionengine.algorithm.promotions.BundlePromotion;
import org.example.promotionengine.algorithm.promotions.PromotionAlgorithmFactory;
import org.example.promotionengine.algorithm.promotions.PromotionAlgorithmFactoryImpl;
import org.example.promotionengine.algorithm.promotions.SingleLinePromotion;
import org.example.promotionengine.models.*;
import org.example.promotionengine.service.cart.CartService;
import org.example.promotionengine.service.cart.CartServiceImpl;
import org.example.promotionengine.service.product.ProductService;
import org.example.promotionengine.service.product.ProductServiceFactory;
import org.example.promotionengine.service.product.ProductServiceFactoryImpl;
import org.example.promotionengine.service.product.StaticProductService;
import org.example.promotionengine.service.promotion.PromotionService;
import org.example.promotionengine.service.promotion.PromotionServiceFactory;
import org.example.promotionengine.service.promotion.PromotionServiceFactoryImpl;
import org.example.promotionengine.service.promotion.StaticPromotionService;

import java.math.BigDecimal;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("Promotion Engine Started");

        StaticPromotionService staticPromotionService = new StaticPromotionService();
        PromotionServiceFactory promotionServiceFactory = new PromotionServiceFactoryImpl(staticPromotionService);
        PromotionService promotionService = promotionServiceFactory.getPromotionService();
        List<PromotionItem> promotionItemList = promotionService.getPromotionItems();

        RateBasedDiscountCalculator rateBasedDiscountCalculator = new RateBasedDiscountCalculator();
        AmountBasedDiscountCalculator amountBasedDiscountCalculator = new AmountBasedDiscountCalculator();
        DiscountCalculatorFactory discountCalculatorFactory = new DiscountCalculatorFactoryImpl(amountBasedDiscountCalculator,rateBasedDiscountCalculator);

        SingleLinePromotion singleLinePromotion = new SingleLinePromotion(discountCalculatorFactory);
        BundlePromotion bundlePromotion = new BundlePromotion(discountCalculatorFactory);
        PromotionAlgorithmFactory promotionAlgorithmFactory = new PromotionAlgorithmFactoryImpl(singleLinePromotion,bundlePromotion);

        // Products
        StaticProductService staticProductService = new StaticProductService();
        ProductServiceFactory productServiceFactory = new ProductServiceFactoryImpl(staticProductService);
        ProductService productService = productServiceFactory.getProductService();

        Product product1 = productService.getProduct(SkuId.A,"Product-1", BigDecimal.valueOf(50));
        Product product2 = productService.getProduct(SkuId.B,"Product-2", BigDecimal.valueOf(30));
        Product product3 = productService.getProduct(SkuId.C,"Product-3", BigDecimal.valueOf(20));
        Product product4 = productService.getProduct(SkuId.D,"Product-4", BigDecimal.valueOf(15));

        //Carts

        //Testcase 1
        CartService cartService = new CartServiceImpl(promotionAlgorithmFactory);
        Cart cart = cartService.createCart();
        CartItem cartItem =cartService.createCartItem(product1,1);
        CartItem cartItem1 =cartService.createCartItem(product2,1);
        CartItem cartItem2 =cartService.createCartItem(product3,1);
        cartService.addToCart(cart,cartItem);
        cartService.addToCart(cart,cartItem1);
        cartService.addToCart(cart,cartItem2);
        cartService.updatePromotion(cart,promotionItemList);
        System.out.println("TestCase1 : CartTotal After Promotion "+cart.getTotalAmount());

        //Test Case 2
        Cart cart2 = cartService.createCart();
        CartItem cart2Item =cartService.createCartItem(product1,5);
        CartItem cart2Item1 =cartService.createCartItem(product2,5);
        CartItem cart2Item2 =cartService.createCartItem(product3,1);
        cartService.addToCart(cart2,cart2Item);
        cartService.addToCart(cart2,cart2Item1);
        cartService.addToCart(cart2,cart2Item2);
        cartService.updatePromotion(cart2,promotionItemList);
        System.out.println("TestCase2 : CartTotal After Promotion "+cart2.getTotalAmount());

        //Test Case 3
        Cart cart3 = cartService.createCart();
        CartItem cart3Item =cartService.createCartItem(product1,3);
        CartItem cart3Item1 =cartService.createCartItem(product2,5);
        CartItem cart3Item2 =cartService.createCartItem(product3,1);
        CartItem cart3Item3 =cartService.createCartItem(product4,1);
        cartService.addToCart(cart3,cart3Item);
        cartService.addToCart(cart3,cart3Item1);
        cartService.addToCart(cart3,cart3Item2);
        cartService.addToCart(cart3,cart3Item3);
        cartService.updatePromotion(cart3,promotionItemList);
        System.out.println("TestCase3 : CartTotal After Promotion "+cart3.getTotalAmount());
    }
}

