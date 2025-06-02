package spring.spring_basics_practice.order;

public interface OrderService {

    //Method
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
