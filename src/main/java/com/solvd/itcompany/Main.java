package com.solvd.itcompany;

import com.solvd.itcompany.enums.Department;
import com.solvd.itcompany.enums.ProjectPriority;
import com.solvd.itcompany.enums.SeniorityLevel;
import com.solvd.itcompany.exceptions.InsufficientFundsException;
import com.solvd.itcompany.exceptions.InvalidProgressException;
import com.solvd.itcompany.generics.Repository;
import com.solvd.itcompany.generics.SystemMessage;
import com.solvd.itcompany.generics.Validator;
import com.solvd.itcompany.interfaces.AccessValidator;
import com.solvd.itcompany.interfaces.DepartmentFilter;
import com.solvd.itcompany.interfaces.FileFormatter;
import com.solvd.itcompany.model.Records.ProductRecord;
import com.solvd.itcompany.model.People.Employee;
import com.solvd.itcompany.model.AboutProduct.ProgramProgress;
import com.solvd.itcompany.model.Financial.BalanceSheet;
import com.solvd.itcompany.model.Financial.BankAccount;
import com.solvd.itcompany.model.Financial.OperatingExpenses;
import com.solvd.itcompany.model.Payment.PaymentMethod;
import com.solvd.itcompany.model.People.Client;
import com.solvd.itcompany.model.Pricing.ProgramPricing;
import com.solvd.itcompany.model.SalesTeam.Sales;
import com.solvd.itcompany.model.SalesTeam.SalesHardware;
import com.solvd.itcompany.model.SalesTeam.SalesSoftware;
import com.solvd.itcompany.model.Service.AccessService;
import com.solvd.itcompany.model.Service.EmployeeService;
import com.solvd.itcompany.model.Service.FileService;
import com.solvd.itcompany.model.Support.ClientSupport;
import com.solvd.itcompany.model.Support.EmployeeFactory;
import com.solvd.itcompany.model.Support.SupportHardware;
import com.solvd.itcompany.model.Support.SupportSoftware;
import com.solvd.itcompany.model.Records.ProductRecord;
import com.solvd.itcompany.model.Records.ProjectAssignment;
import com.solvd.itcompany.model.Records.WordResult;
import com.solvd.itcompany.model.Financial.BankAccount;
import com.solvd.itcompany.model.People.Client;
import com.solvd.itcompany.model.Service.ReflectionInspector;
import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

import static com.solvd.itcompany.model.Service.AccessService.checkDepartmentAccess;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Employee dev1 = new Employee("John", 42, "Male", "Dev", 4020);
        Client clt1 = new Client("Female", 37, "Juliee", "35x4d2");
        Client clt2 = new Client("Male", 57, "Omir", "47x4a8");
        BankAccount cc1 = new BankAccount(clt1, 300, "abc", 3600);
        BankAccount cc2 = new BankAccount(clt2, 301, "abd", 200);
        logger.info("/////////////////////////");


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(dev1);


        Set<Client> clientSet = new HashSet<>();
        clientSet.add(clt1);
        clientSet.add(clt2);


        Map<Integer, BankAccount> accountMap = new HashMap<>();
        accountMap.put(cc1.getAccountNumber(), cc1);


        Queue<String> supportTickets = new LinkedList<>();
        supportTickets.add("Ticket #4020 - Server Down");
        supportTickets.add("Ticket #4021 - Password Reset");

        Sales salesHardware = new SalesHardware();
        Sales salesSoftware = new SalesSoftware();
        salesSoftware.marketing();
        salesSoftware.meetingWithClient();
        salesHardware.marketing();
        salesHardware.meetingWithClient();
        logger.info("/////////////////////////");

        cc1.setBalance(5000);
        logger.info(cc1.getOwner().getName() + " your current balance is: " + cc1.getBalance());
        cc1.addBalance(2200);
        logger.info(cc1.getOwner().getName() + " your current balance is: " + cc1.getBalance());
        logger.info("/////////////////////////");

        ProgramPricing program1 = new ProgramPricing(2, "Frontend");
        ProgramPricing program2 = new ProgramPricing(5, "Front+back");
        double totalTimep1 = program1.calculateTime(2);
        OperatingExpenses ope1 = new OperatingExpenses(1200, 500);
        double totalExpenses1 = ope1.calculateTotal(ope1.getSoftwarePrice(), ope1.getOfficeSuppliesPrice());
        double totalPrice1 = program1.calculatePrice(totalTimep1, 2, totalExpenses1);
        logger.info("Hours total:" + totalTimep1 + ". Price total: " + totalPrice1 + ".");
        double totalTimep2 = program2.calculateTime(1);
        OperatingExpenses ope2 = new OperatingExpenses(700, 100);
        double totalExpenses2 = ope2.calculateTotal(ope2.getSoftwarePrice(), ope2.getOfficeSuppliesPrice());
        double totalPrice2 = program2.calculatePrice(totalTimep2, 1, totalExpenses2);
        logger.info("Hours total:" + totalTimep2 + ". Price total: " + totalPrice2 + ".");
        logger.info("/////////////////////////");

        PaymentMethod.credit(cc1, program1, 10);
        PaymentMethod.debit(cc1, program1);
        PaymentMethod.credit(cc2, program2, 5);
        PaymentMethod.debit(cc2, program2);
        logger.info("/////////////////////////");

        ClientSupport supSoft = new SupportSoftware();
        ClientSupport supHard = new SupportHardware();
        supSoft.helpClient(clt1);
        supHard.helpClient(clt1);
        logger.info("/////////////////////////");

        BalanceSheet balanceFirstSemester = new BalanceSheet();
        BalanceSheet balanceSecondSemester = new BalanceSheet();
        BalanceSheet.updateBalance(program1, ope1, balanceFirstSemester.getTotalSavings());
        BalanceSheet.updateBalance(program2, ope2, balanceSecondSemester.getTotalSavings());
        logger.info("/////////////////////////");

        ProductRecord prod1 = new ProductRecord(1,500, clt1);
        ProductRecord prod2 = new ProductRecord(56,900, clt2);
        ProgramProgress.showProgress(clt1, prod1);
        ProgramProgress.showProgress(clt2, prod2);
        logger.info("/////////////////////////");

        List<ProductRecord> productHistory = new LinkedList<>();
        productHistory.add(prod1);


        ProgramProgress.showProgress(clt1, prod1);
        ProgramProgress.showProgress(clt2, prod2);
        logger.info("/////////////////////////");

        logger.info(clt1);
        logger.info(prod1);
        logger.info(cc1);
        logger.info(balanceFirstSemester);
        logger.info(program1);
        logger.info("/////////////////////////");

        logger.info(cc1.equals(cc2));
        cc1 = cc2;
        logger.info(cc1.equals(cc2));
        logger.info("/////////////////////////");

        logger.info(balanceFirstSemester.calculateProfit());
        balanceFirstSemester.generateSummary();
        clt1.greet();
        dev1.performAction("a new software feature.");


        logger.info("Hello World!");


        try {
            cc1.withdraw(5000.0);
            logger.info("Withdrawal successful. New balance: $" + cc1.getBalance());
        } catch (InsufficientFundsException e) {
            logger.error("Error: " + e.getMessage());
        } finally {
            logger.info("Operation finished.");
        }

        try {
            float newProgress1 = 22f;
            float newProgress2 = 150f;

            ProgramProgress.validateProgress(newProgress1);


            ProgramProgress.validateProgress(newProgress2);


        } catch (InvalidProgressException e) {
            logger.error("Error updating progress: {}", e.getMessage());
        }



        Repository<Employee> employeeRepo = new Repository<>();
        employeeRepo.add(dev1);
        Repository<Client> clientRepo = new Repository<>();
        clientRepo.add(clt1);
        clientRepo.add(clt2);

        logger.info("Employees in repository: {}", employeeRepo.getCount());
        logger.info("Clients in repository: {}", clientRepo.getCount());

        logger.info("/////////////////////////");

        if (Validator.isValid(prod1)) {
            logger.info("Product validation passed: Object is not null.");
        } else {
            logger.warn("Product validation failed!");
        }

        boolean isClientValid = Validator.isValid(clt1);
        logger.info("Is client data valid? {}", isClientValid);

        SystemMessage<Client> clientMsg = new SystemMessage<>(clt1);
        clientMsg.printAlert("Login Attempt");

        SystemMessage<Employee> employeeAlert = new SystemMessage<>(dev1);
        employeeAlert.printAlert("Accessing Financial Records");


        Employee dev2 = new Employee("John", SeniorityLevel.SENIOR, Department.IT);

        logger.info("Employee Created: " + dev2.getName());
        logger.info("Seniority: " + dev2.getSeniority().getDescription());
        logger.info("Department: " + dev2.getDepartment().getFullName());

        checkDepartmentAccess(dev2.getDepartment());
        checkDepartmentAccess(dev1.getDepartment());

        ProjectPriority currentTask = ProjectPriority.HIGH;
        AccessService.processTicket(currentTask);
        AccessService.processTicket(ProjectPriority.URGENT);


        String inputPath = "src/main/resources/words.txt";
        String outputPath = "src/main/resources/result_count.txt";

        String[] wordsToFind = {"Responsibility", "Career", "Chaos", "Evolution", "Competence"};

        FileFormatter myFormatter = (words, count) ->
                String.format("[%s] -> Found %d times in the article", words.toUpperCase(), count);


        try {
            FileService.countSpecialWords(inputPath, outputPath, wordsToFind, myFormatter);
        } catch (IOException e) {
            logger.error("Error processing the file: " + e.getMessage());
        }


        AccessValidator seniorityCheck = (employee, level) ->
                employee.getSeniority().toString().equalsIgnoreCase(level);

        AccessService.grantApproval(dev2, "SENIOR", (e, lvl) -> e.getSeniority().toString().equals(lvl));


        List<Employee> staff = EmployeeFactory.createStaff();
        DepartmentFilter itRule = (e, dept) -> e.getDepartment().toString().equals(dept);
        List<Employee> itTeam = EmployeeService.filterByDepartment(staff, "IT", itRule);
        logger.info("--- IT Department Staff ---");
        itTeam.forEach(e -> logger.info("Employee found: {}", e.getName()));



        logger.info("--- STARTING REFLECTION TESTS ---");

        WordResult word = new WordResult("Java", 25);
        ReflectionInspector.analyzeObject(word);

        ProductRecord product = new ProductRecord(0.75f, 1200.0, clt1);
        ReflectionInspector.analyzeObject(product);

        ProjectAssignment assignment = new ProjectAssignment(
                "Alice Smith",
                "Cloud Integration",
                LocalDate.now()
        );
        ReflectionInspector.analyzeObject(assignment);

        BankAccount account = new BankAccount(clt1, 987654, "jgosling", 50000.0);
        ReflectionInspector.analyzeObject(account);

        logger.info("--- REFLECTION TESTS COMPLETED ---");
    }

}