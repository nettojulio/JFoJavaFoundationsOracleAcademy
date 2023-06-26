package br.com.julioneto.exercicio002.problemset003;

import java.util.List;

public class SnakeBoxFactory {
    class PaperBox {
        private String color;
        private String size;
        private double price;

        public PaperBox(String color, String size, double price) {
            this.color = color;
            this.size = size;
            this.price = price;
        }

        public void closeBox() {
            System.out.println("It's closed");
        }

        public void makeNoise() {
            System.out.println("Bang!");
        }

        public void openBox() {
            System.out.println("It's open");
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    class Snake {
        private String color;
        private double length;
        private boolean poisonous;

        public Snake(String color, double length, boolean poisonous) {
            this.color = color;
            this.length = length;
            this.poisonous = poisonous;
        }

        public void wrapEnemy() {
            System.out.println("Wrapping Enemy");
        }

        public void climbTree() {
            System.out.println("Climbing");
        }

        public void biteEnemy() {
            System.out.println("Bite enemy");

            if (this.poisonous) {
                System.out.println("Enemy poisoned");
            }
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public boolean isPoisonous() {
            return poisonous;
        }

        public void setPoisonous(boolean poisonous) {
            this.poisonous = poisonous;
        }
    }

    class Order {
        private List<PaperBox> items;
        private double total;
        private String paymentMethod;
        private String user;

        public Order(List<PaperBox> items, double total, String paymentMethod, String user) {
            this.items = items;
            this.total = total;
            this.paymentMethod = paymentMethod;
            this.user = user;
        }

        public void addItem(PaperBox item) {
            items.add(item);
        }

        public boolean approvedTransaction(String cardInfo) {
            return !"".equals(cardInfo.trim()) && !"0000".equals(cardInfo);
        }

        public void rewards(String user) {
            if ("VIP".equals(user)) {
                System.out.println("Send a gift");
            }
        }

        public List<PaperBox> getItems() {
            return items;
        }

        public void setItems(List<PaperBox> items) {
            this.items = items;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }
}
