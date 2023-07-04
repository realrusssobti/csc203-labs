import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Runner
{
    //constants to be used when pulling data out of input
    //leave these here and refer to them to pull out values
    private static final String START_TAG = "START";
    private static final int START_NUM_FIELDS = 3;
    private static final int START_SESSION_ID = 1;
    private static final int START_CUSTOMER_ID = 2;
    private static final String BUY_TAG = "BUY";
    private static final int BUY_NUM_FIELDS = 5;
    private static final int BUY_SESSION_ID = 1;
    private static final int BUY_PRODUCT_ID = 2;
    private static final int BUY_PRICE = 3;
    private static final int BUY_QUANTITY = 4;
    private static final String VIEW_TAG = "VIEW";
    private static final int VIEW_NUM_FIELDS = 4;
    private static final int VIEW_SESSION_ID = 1;
    private static final int VIEW_PRODUCT_ID = 2;
    private static final int VIEW_PRICE = 3;
    private static final String END_TAG = "END";
    private static final int END_NUM_FIELDS = 2;
    private static final int END_SESSION_ID = 1;


    //a good example of what you will need to do next'
    //creates a map of sessions to customer ids

    private static void processLine(
            final String line,
            final List<Customer> customers
            /* add parameters as needed */
    )
    {
        final String[] words = line.split("\\h");

        if (words.length == 0)
        {
            return;
        }

        switch (words[0])
        {
            case START_TAG:
                processStartEntry(words, customers /* add arguments as needed */);
                break;
            case VIEW_TAG:
                processViewEntry(words, customers /* add arguments as needed */ );
                break;
            case BUY_TAG:
                processBuyEntry(words, customers /* add arguments as needed */ );
                break;
            case END_TAG:
                processEndEntry(words /* add arguments as needed */ );
                break;
        }
    }

    private static void processEndEntry(String[] words) {
    }

    private static void processBuyEntry(String[] words, List<Customer> customers) {
        // Example Buy Line: BUY session1 product1 100 2
        // Get the session
        for (Customer customer : customers) {
            for (Session session : customer.getSessions()) {
                if (session.getId().equals(words[BUY_SESSION_ID])) {
                    // Add the purchase to the session
                    Purchase purchase = new Purchase(words[BUY_PRODUCT_ID], Integer.parseInt(words[BUY_PRICE]), Integer.parseInt(words[BUY_QUANTITY]));
                    session.addPurchase(purchase);
                    break;
                }
            }
        }

    }

    private static void processViewEntry(String[] words, List<Customer> customers) {
        // Example View Line: VIEW session1 product1 100
        // Get the session
        for (Customer customer : customers) {
            for (Session session : customer.getSessions()) {
                if (session.getId().equals(words[VIEW_SESSION_ID])) {
                    // Add the view to the session
                    View view = new View(words[VIEW_PRODUCT_ID], Integer.parseInt(words[VIEW_PRICE]));
                    session.addView(view);
                    break;
                }
            }
        }

    }

    private static void processStartEntry(String[] words, List<Customer> customers) {
        // Example Start Line: START session1 customer1
        // Determine if the customer is already in the list
        // If not, add them
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.getId().equals(words[START_CUSTOMER_ID])) {
                // Add the session to the customer
                Session session = new Session(words[START_SESSION_ID], words[START_CUSTOMER_ID]);
                customer.addSession(session);
                // Add the session to the list of sessions
                found = true;
                break;
            }

        }
        if(!found){
            // create a new customer
            Customer customer = new Customer(words[START_CUSTOMER_ID]);
            // Add the session to the customer
            Session session = new Session(words[START_SESSION_ID], words[START_CUSTOMER_ID]);
            customer.addSession(session);
            // Add the customer to the list of customers
            customers.add(customer);
        }
    }

    //write this after you have figured out how to store your data
    //make sure that you understand the problem
    private static void printSessionPriceDifference(List<Customer> customers)
    {
        System.out.println("Price Difference for Purchased Product by Session");
        // calculate the average price of all products viewed
        for(Customer customer: customers){
            for(Session session: customer.getSessions()){
                int total = 0;
                int count = 0;
                for(View view: session.getViews()){
                    total += view.getPrice();
                    count++;
                }
                int average;
                if(count == 0){
                    average = total;
                }
                else{average = total/count;}

                // Now, get the difference between the purchased item's prices and the average
                for(Purchase purchase: session.getPurchases()){
                    int difference = purchase.getPrice() - average;
                    System.out.println("Session: " + session.getId() + " Product: " + purchase.getProduct() + " Difference: " + difference);
                }
            }
        }

        /* add printing */
    }
    {
        System.out.println("Price Difference for Purchased Product by Session");

        /* add printing */
    }

    //write this after you have figured out how to store your data
    //make sure that you understand the problem
    private static void printCustomerItemViewsForPurchase(
List<Customer> customers    )
    {
        System.out.println("Number of Views for Purchased Product by Customer");
        for(Customer customer: customers){
            // get a list of all the products purchased
            List<String> products = new ArrayList<>();
            for(Session session: customer.getSessions()){
                for(Purchase purchase: session.getPurchases()){
                    products.add(purchase.getProduct());
                }
            }
            // Now, get the number of views for each product
            for(String product: products){
                int count = 0;
                for(Session session: customer.getSessions()){
                    for(View view: session.getViews()){
                        if(view.getProduct().equals(product)){
                            count++;
                            break;
                        }
                    }
                }
                System.out.println("Customer: " + customer.getId() + " Product: " + product + " Views: " + count);
            }
        }
        /* add printing */
    }

    //write this after you have figured out how to store your data
    //make sure that you understand the problem
    private static void printStatistics(
            List<Customer> customers)
    {
        printAverageViewsNoPurchase(customers);
        printSessionPriceDifference(customers);
        printCustomerItemViewsForPurchase(customers);

      /* This is commented out as it will not work until you read
         in your data to appropriate data structures, but is included
         to help guide your work - it is an example of printing the
         data once propogated
         printOutExample(sessionsFromCustomer, viewsFromSession, buysFromSession);
      */
    }

    private static void printAverageViewsNoPurchase(List<Customer> customers) {
        // Average views without purchase: the number of Views for a Session where the number of Purchases is 0
        System.out.println("Average Views without Purchase");
        // List of Integers to hold the number of views for each session
        List<Integer> views = new ArrayList<>();
        for(Customer customer: customers){
            for(Session session: customer.getSessions()){
                if(session.getPurchases().size() == 0){
                    views.add(session.getViews().size());
                }
            }
        }
        //average the views
        int total = 0;
        for(int view: views){
            total += view;
        }
        int average = total/views.size();
        System.out.println(average);
    }

    private static void processFile(
            final Scanner input,
            final List<Customer> customers
            /* add parameters as needed */
    )
    {
        while (input.hasNextLine())
        {
            processLine(input.nextLine(), customers
                    /* add arguments as needed */ );
        }
    }

    //called from main - mostly just pass through important data structures
    private static void populateDataStructures(
            final String filename,
            final List<Customer> customers
            /* add parameters as needed */
    )
            throws FileNotFoundException
    {
        try (Scanner input = new Scanner(new File(filename)))
        {
            processFile(input, customers
                    /* add arguments as needed */ );
        }
    }

    private static String getFilename(String[] args)
    {
        if (args.length < 1)
        {
            System.err.println("Log file not specified.");
            System.exit(1);
        }

        return args[0];
    }

    public static void main(String[] args)
    {
        /* Map from a customer id to a list of session ids associated with
         * that customer.
         */
        final List<Customer> customers = new ArrayList<Customer>();

        /* create additional data structures to hold relevant information */
        /* they will most likely be maps to important data in the logs */

        final String filename = getFilename(args);

        try
        {
            populateDataStructures(filename, customers);
            printStatistics(customers);
        }
        catch (FileNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
