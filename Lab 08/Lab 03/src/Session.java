import java.util.ArrayList;
import java.util.List;

public class Session {
    private final String id;
    private final String customer;
    private List<Purchase> purchases = new ArrayList<Purchase>();
    private List<View> views = new ArrayList<View>();
    public Session(String id, String customer) {
        this.id = id;
        this.customer = customer;
    }
    public String getId() {
        return id;
    }
    public String getCustomer() {
        return customer;
    }
    public List<Purchase> getPurchases() {
        return purchases;
    }
    public List<View> getViews() {
        return views;
    }
    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }
    public void addView(View view) {
        views.add(view);
    }
}
