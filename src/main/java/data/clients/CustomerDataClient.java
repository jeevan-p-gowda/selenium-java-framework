package data.clients;

import models.Customer;

public class CustomerDataClient extends DataClient {
    public Customer getValidCustomerOfType(String key) {
        String filePath = getFilePath("customers/valid_customers.json");
        return dataMapper.map(filePath, key, Customer.class);
    }
}
