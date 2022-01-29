import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private List<Product> products;

    public Instock() {
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public boolean contains(Product product) {
        return products.stream().anyMatch(p -> p.getLabel().equals(product.getLabel()));
    }

    @Override
    public void add(Product product) {
        if (!contains(product)) {
            products.add(product);
        }
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        products.stream().filter(p -> p.getLabel().equals(product)).findAny()
                .orElseThrow(IllegalArgumentException::new).setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        return products.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        return products.stream().filter(p -> p.getLabel().equals(label)).findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count >= 0 && count < products.size()) {
            return products.stream().sorted(Comparator.comparing(Product::getLabel)).limit(count).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return products.stream().filter(p -> p.getPrice() > lo && p.getPrice() <= hi)
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed()).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return products.stream().filter(p -> p.getPrice() == price).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count <= products.size()) {
            return products.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                    .limit(count).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return products.stream().filter(p -> p.getQuantity() == quantity).collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
