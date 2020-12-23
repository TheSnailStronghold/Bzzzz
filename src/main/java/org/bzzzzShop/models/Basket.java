package org.bzzzzShop.models;
import org.bzzzzShop.models.Customer;
import org.bzzzzShop.models.Goods;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Basket {

    private UUID uuid;
    private Map<Goods,Integer> content = new HashMap<>();
    private int contentNumber = 0;

    public Map<Goods, Integer> getContent() {
        return content;
    }

    public Basket() {
        this.uuid = UUID.randomUUID();
    }

    public void addGood(Goods product){
        if(!content.containsKey(product)){
            content.put(product, 1);
        }else{
            content.put(product,content.get(product)+1);
        }
        contentNumber++;
    }
    public void deleteGood(Goods product){
        if(content.containsKey(product)){
            if(content.put(product, content.get(product)-1)==1){
                content.remove(product);
            }
            contentNumber--;
        }
    }
    public void emptyBasket(){
        content.clear();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();

        if(content.isEmpty()) return "Корзина пуста.";

        str.append("СОДЕРЖИМОЕ КОРЗИНЫ:\n");
        for (Map.Entry<Goods, Integer> item : content.entrySet()) {
            str.append(String.format("Наименование товара: %s\n" +
                            "Количество товаров в корзине: %s\n",
                    item.getKey(), item.getValue()));
            str.append("--------------------------------------------\n");
        }
        str.append("Суммарное число товаров в корзине: " + this.contentNumber + "\n");
        str.append("============================================\n");
        return str.toString();

    }
}
