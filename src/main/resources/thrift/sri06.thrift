namespace java edu.pja.sri.lab06

struct Product {
    1: required i32 id;
    2: required string name;
    3: required double price;
    4: required i32 inStock;
}

exception ProductUnvailable {
    1: string message
}

service ProductManager {
    list<Product> getProducts()
}

struct BankAccount {
    1: required i32 id;
    2: required double state;
}

struct Customer {
    1: required i32 id;
    2: required string ownerName;
}

service BankAccountManager {
    Customer createCustomer(string ownerName);
    BankAccount createBankAccount(string ownerName);
    double withdrawMoney(string ownerName, double amount);
    double putMoney(string ownerName,  double amount);
}

struct Test {
    1: optional string s;
}

service TestManager {
    list<Test> getTestList(string param);
}
