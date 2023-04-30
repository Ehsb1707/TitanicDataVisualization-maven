import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {
    private List<Passenger> passengerList;
    private JComboBox<String> passengerPClass;
    private JComboBox<String> passengerSexBox;
    private JComboBox<String> passengerEmbarked;

    private JTextField passengerIdMax;
    private JTextField passengerIdMin;
    private JTextField passengerAgeMixIm;
    private JTextField passengerAgeMinIm;
    private JTextField passengersName;
    private JTextField passengerSibAndSb;
    private JTextField passengerPraAndCh;
    private JTextField passengerTickets;
    private JTextField passengerFareMaxim;
    private JTextField passengerFareMinim;
    private JTextField passengerCabinsIn;

    private JButton search;
    private JButton stat;
    private String minId;
    private String maxId;
    private String minFare;
    private String maxFare;
    private String typeClassOfClass;
    private String typeClassOfSex;
    private String typeClassOfEmbarked;
    private String name;
    private String sibSb;
    private String parch;
    private String ticket;
    private String cabins;
    private String minAge;
    private String maxAge;
    private int counter = 0;


    public MainPanel (int x, int y, int width, int height) throws IOException {
        File fileOfCsv = new File(Constants.PATH_TO_DATA_FILE);
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

        createPassengerList(fileOfCsv);
        allUserFilter();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon("titanic.png");
        imageIcon.paintIcon(this,g,0,0);
    }

    public List<Passenger> getPassengerList () {
        return passengerList;
    }

    public void setPassengerList (List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public void allUserFilter () throws IOException {
        JLabel passengerClassLabel = new JLabel("Passenger Class :");
        passengerClassLabel.setBounds(Constants.X_LABEL , Constants.X_AND_Y , Constants.LABEL_WIDTH2 , Constants.LABEL_HEIGHT2);
        this.add(passengerClassLabel);
        this.passengerPClass = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.passengerPClass.setBounds(Constants.X_BOX, Constants.X_AND_Y, Constants.COMBO_BOX_WIDTH , Constants.COMBO_BOX_HEIGHT);
        this.add(this.passengerPClass);

        JLabel passengerSex = new JLabel("Passenger Sex : ");
        passengerSex.setBounds(Constants.X_LABEL, Constants.Y_LABEL, Constants.LABEL_WIDTH , Constants.LABEL_HIGH_BOUNDS);
        this.add(passengerSex);
        this.passengerSexBox = new JComboBox<>(Constants.SEX_PASSENGER);
        this.passengerSexBox.setBounds(Constants.X_BOX, Constants.Y_LABEL2, Constants.WIDTH_LABEL, Constants.LABEL_HIGH_BOUNDS);
        this.add(this.passengerSexBox);

        JLabel passengerEmbarked = new JLabel("Passenger Embarked : ");
        passengerEmbarked.setBounds(Constants.X_LABEL, Constants.Y_LABEL3, Constants.LABEL_WIDTH3, Constants.LABEL_HIGH_BOUNDS);
        this.passengerEmbarked =  new JComboBox<>(Constants.EMBARKED_PASSENGERS);
        this.passengerEmbarked.setBounds(Constants.X_BOX, Constants.Y_LABEL4, Constants.BOUNDS_WIDTH, Constants.LABEL_HEIGHT2);
        this.add(this.passengerEmbarked);

        JLabel passengerIdMinin = new JLabel("Passenger ID Min : ");
        passengerIdMinin.setBounds(Constants.X_LABEL, Constants.Y1, Constants.LABEL_WIDTH3, Constants.LABEL_HIGH_BOUNDS);
        this.add(passengerIdMinin);
        this.passengerIdMin = new JTextField("");
        this.passengerIdMin.setBounds(Constants.X_BOX, Constants.Y2 , Constants.BOUNDS_WIDTH, Constants.LABEL_HEIGHT2);
        this.add(this.passengerIdMin);

        JLabel passengerIDMaxin = new JLabel("Passenger ID Max : ");
        passengerIDMaxin.setBounds(Constants.X_LABEL, Constants.Y3, Constants.LABEL_WIDTH3, Constants.LABEL_HIGH_BOUNDS);
        this.add(passengerIDMaxin);
        this.passengerIdMax = new JTextField("");
        this.passengerIdMax.setBounds(Constants.X_BOX, Constants.Y4, Constants.BOUNDS_WIDTH, Constants.LABEL_HEIGHT2);
        this.add(this.passengerIdMax);

        JLabel passengerName = new JLabel("Passenger Name : ");
        passengerName.setBounds(Constants.X_LABEL , Constants.Y5, Constants.LABEL_WIDTH3 , Constants.LABEL_HIGH_BOUNDS);
        this.add(passengerName);
        this.passengersName = new JTextField("");
        this.passengersName.setBounds(Constants.X_BOX, Constants.Y6 , Constants.BOUNDS_WIDTH, Constants.LABEL_HEIGHT2);
        this.add(this.passengersName);

        JLabel passengerSibSb = new JLabel("Passenger Sib & Sp :");
        passengerSibSb.setBounds(Constants.X_LABEL, Constants.Y9, Constants.LABEL_WIDTH3 , Constants.LABEL_HIGH_BOUNDS);
        this.add(passengerSibSb);
        this.passengerSibAndSb = new JTextField("");
        this.passengerSibAndSb.setBounds(Constants.X_BOX, Constants.Y8, Constants.BOUNDS_WIDTH, Constants.LABEL_HEIGHT2);
        this.add(this.passengerSibAndSb);

        JLabel passengerParch = new JLabel("Passenger Parch : ");
        passengerParch.setBounds(Constants.X_LABEL, Constants.Y9 , Constants.LABEL_WIDTH3, Constants.LABEL_HIGH_BOUNDS);
        this.add(passengerParch);
        this.passengerPraAndCh = new JTextField("");
        this.passengerPraAndCh.setBounds(Constants.X_BOX, Constants.Y10, Constants.BOUNDS_WIDTH, Constants.LABEL_HIGH_BOUNDS);
        this.add(this.passengerSibAndSb);

        JLabel passengerTicket = new JLabel("Passenger Ticket :");
        passengerTicket.setBounds(Constants.X_LABEL, Constants.Y11, Constants.LABEL_WIDTH3, Constants.LABEL_HEIGHT2);
        this.add(passengerTicket);
        this.passengerTickets = new JTextField("");
        this.passengerTickets.setBounds(Constants.X_BOX, Constants.Y12, Constants.BOUNDS_WIDTH, Constants.LABEL_HEIGHT2);
        this.add(this.passengerTickets);

        JLabel passengerFareMax = new JLabel("Passenger Max Fare : ");
        passengerFareMax.setBounds(Constants.X_LABEL, Constants.Y13, Constants.LABEL_WIDTH3, Constants.LABEL_HIGH_BOUNDS);
        this.add(passengerFareMax);
        this.passengerFareMaxim = new JTextField("");
        this.passengerFareMaxim.setBounds(Constants.X_BOX, Constants.Y14, Constants.BOUNDS_WIDTH, Constants.LABEL_HEIGHT2);
        this.add(this.passengerFareMaxim);

        JLabel passengerFareMin = new JLabel("Passenger Min Fare: ");
        passengerFareMin.setBounds(Constants.X_LABEL, Constants.Y15, Constants.LABEL_WIDTH3, Constants.LABEL_HIGH_BOUNDS);
        this.add(passengerFareMin);
        this.passengerFareMinim = new JTextField("");
        this.passengerFareMinim.setBounds(Constants.X_BOX, Constants.Y16, Constants.BOUNDS_WIDTH, Constants.LABEL_HEIGHT2);
        this.add(this.passengerFareMinim);


        JLabel passengerCabin = new JLabel("Passenger Cabin: ");
        passengerCabin.setBounds(Constants.X_LABEL, Constants.Y17, Constants.LABEL_WIDTH3, Constants.LABEL_HIGH_BOUNDS);
        this.add(passengerCabin);
        this.passengerCabinsIn = new JTextField("");
        this.passengerCabinsIn.setBounds(Constants.X_BOX, Constants.Y18, Constants.BOUNDS_WIDTH, Constants.LABEL_HEIGHT2);
        this.add(this.passengerCabinsIn);


        JLabel passengerAgeMin = new JLabel("Passenger AGE MIN: ");
        passengerAgeMin.setBounds(passengerIdMinin.getWidth() + passengerIdMinin.getX(), Constants.Y1, Constants.LABEL_WIDTH3, Constants.LABEL_HIGH_BOUNDS);
        this.add(passengerAgeMin);
        this.passengerAgeMinIm = new JTextField("");
        this.passengerAgeMinIm.setBounds(passengerAgeMin.getWidth() + passengerAgeMin.getX(), Constants.Y2, Constants.BOUNDS_WIDTH, Constants.LABEL_HEIGHT2);
        this.add(this.passengerAgeMinIm);

        JLabel passengerAgeMax = new JLabel("Passenger AGE MAX: ");
        passengerAgeMax.setBounds(passengerAgeMixIm.getWidth() + passengerAgeMixIm.getX(), Constants.Y3, Constants.LABEL_WIDTH3, Constants.LABEL_HIGH_BOUNDS);
        this.add(passengerAgeMax);
        this.passengerAgeMixIm = new JTextField("");
        this.passengerAgeMixIm.setBounds(passengerAgeMax.getWidth() + passengerAgeMax.getX(), Constants.Y4, Constants.BOUNDS_WIDTH, Constants.LABEL_HEIGHT2);
        this.add(this.passengerAgeMixIm);

        this.search = new JButton("Search Button");
        this.search.setBounds(Constants.X_BUTTON, Constants.Y19, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.add(this.search);

        search.addActionListener(e -> {
            try {
                callInitialization();
                callFiltering();
                writeToFile();
                survivedFilter();
            }catch (IOException exception) {
                exception.printStackTrace();
            }
        });

        percentageStatistics();
    }

    public int filterPassengerClass (String str) throws IOException {
        System.out.println("Filter Passenger Class");
        int type = 0 ;
        switch (str) {
            case "1st":
                this.passengerList = passengerList.stream().filter(passenger -> passenger.getpClass() == 1).collect(Collectors.toList());
                type = 1 ;
                break;
            case "2nd" :
                this.passengerList = passengerList.stream().filter(passenger -> passenger.getpClass() == 2).collect(Collectors.toList());
                type = 2 ;
                break;
            case "3rd" :
                this.passengerList = passengerList.stream().filter(passenger -> passenger.getpClass() == 3).collect(Collectors.toList());
                type = 3 ;
                break;

            case "All":
                break;
        }
        return type;
    }

    private void createPassengerList (File file) throws FileNotFoundException {
        System.out.println("Create Passenger List : start ");
        int inx = 0;
        String dataLine ;
        this.passengerList = new ArrayList<>();
        if (file.exists()){
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                dataLine = scanner.nextLine();
                if (inx != 0) {
                    Passenger passenger = new Passenger(dataLine);
                    this.passengerList.add(passenger);
                } else {
                    inx ++ ;
                }
            }
        }
    }

    private void writeToFile () {
        try {
            File output = new File(Constants.PATH_TO_DATA_FILE + counter) ;
            counter ++ ;
            FileWriter fileWriter = new FileWriter(output);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print("PassengerId,Survived,pClass,Name,Sex,Age,SibSp,Parch,Ticket,Fare,Cabin,Embarked");
            for (int i = 1 ; i < this.passengerList.size() ; ++ i ) {
                printWriter.println(this.passengerList.get(i));
            }
            printWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public String genderFiltering (String gender) throws IOException {
        System.out.println("Gender Filtering : start ");
        String sexType ;
        if (!gender.isEmpty()){
            if (gender.equals("male")){
                this.passengerList = passengerList.stream().filter(passenger -> passenger.getSex().equals("male")).collect(Collectors.toList());
                sexType = "male";
                return sexType;
            } else if (gender.equals("female")){
                this.passengerList = passengerList.stream().filter(passenger -> passenger.getSex().equals("female")).collect(Collectors.toList());
                sexType = "female";
                return sexType;
            }
        }
        return gender;
    }

    public void filterPassengerEmbark (String str) throws IOException {
        System.out.println("Filer Passenger Embark : start ");
        if (!str.isEmpty()) {
            switch (str) {
                case "C" :
                    this.passengerList = passengerList.stream().filter(passenger -> passenger.getEmbarked().contains("C")).collect(Collectors.toList());
                    break;
                case "Q" :
                    this.passengerList = passengerList.stream().filter(passenger -> passenger.getEmbarked().contains("Q")).collect(Collectors.toList());
                    break;
                case "S" :
                    this.passengerList = passengerList.stream().filter(passenger -> passenger.getEmbarked().contains("S")).collect(Collectors.toList());
                    break;
                case "All" :
                    break;
            }
        }
    }

    public void idRangeFiltering (String minId , String maxId) {
        System.out.println("Id Range Filtering : start");
        int finalMinId , finalMaxId ;
        if (!minId.isEmpty()) {
            finalMinId = Integer.parseInt(minId);
        } else {
            finalMinId = 0;
        }

        if (!maxId.isEmpty()){
            finalMaxId = Integer.parseInt(maxId);
        } else  {
            finalMaxId = Constants.MAX_INDEX_LIST;
        }

        this.passengerList = passengerList.stream().filter(passenger -> (passenger.getPassengerId() <= finalMaxId && passenger.getPassengerId() >= finalMinId)).collect(Collectors.toList());
    }

    public void ageFilter (String minAge , String maxAge) {
        System.out.println("Age Filtering : start");
        int caseMinAge , finalMaxAge ;
        if (!minAge.isEmpty()){
            caseMinAge = Integer.parseInt(minAge);
        } else {
            caseMinAge = 0;
        }

        if (!maxAge.isEmpty()) {
            finalMaxAge = Integer.parseInt(maxAge);
        } else {
            finalMaxAge = 90 ;
        }

        this.passengerList = passengerList.stream().filter(passenger -> (passenger.getPassengerId() <= finalMaxAge && passenger.getPassengerId() >= caseMinAge)).collect(Collectors.toList());
    }

    public void findName (String partOfName)  {
        System.out.println("Find Name : start ");
        if (!name.isEmpty()){
            try {
                this.passengerList = passengerList.stream().filter(passenger -> passenger.getName().contains(partOfName)).collect(Collectors.toList());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void filterSibSb (String numSibSb) throws IOException {
        System.out.println("Number of sibSb filtering : start");
        if (passengerSibAndSb.isEnabled() && !numSibSb.isEmpty()){
            this.passengerList = passengerList.stream().filter(passenger -> Objects.equals(passenger.getSibSp() , numSibSb)).collect(Collectors.toList());
        }
    }

    public void filterParch (String numParch ) throws IOException {
        System.out.println("Number of parch filtering : start");
        if (passengerPraAndCh.isEnabled() && !numParch.isEmpty()) {
            this.passengerList = passengerList.stream().filter(passenger -> passenger.getParch().equals(numParch)).collect(Collectors.toList());
        }
    }

    public void filterTicket (String ticketNum) throws IOException {
        System.out.println("Ticket Filtering : start ");
        if (passengerTickets.isEnabled() && !ticketNum.isEmpty()) {
            this.passengerList = passengerList.stream().filter(passenger -> passenger.getTicket().equals(ticketNum)).collect(Collectors.toList());
        }
    }

    public void rangePriceFiltering (String minFare , String maxFare) throws IOException {
        System.out.println("Ticket Price Filtering : start ");
        double finalMaxFare , finalMinFare ;
        System.out.println("run");
        if (!minFare.isEmpty()) {
            finalMinFare = Double.parseDouble(minFare);
        } else {
            finalMinFare = 0;
        }

        if (!maxFare.isEmpty()){
            finalMaxFare = Double.parseDouble(maxFare);
        } else {
            finalMaxFare = Constants.MAX_FREE;
        }
        this.passengerList = passengerList.stream().filter(passenger -> passenger.getFare() <= finalMaxFare && passenger.getFare() >= finalMinFare).collect(Collectors.toList());
    }

    public void filterCabin (String cabin) {
        System.out.println("Cabin Filtering : start");
        try{
            if (passengerCabinsIn.isEnabled() && !cabin.isEmpty()) {
                this.passengerList = passengerList.stream().filter(passenger -> passenger.getCabin().contains(cabin)).collect(Collectors.toList());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void survivedFilter () {
        System.out.println("Survived Filtering : start");
        String rows = "Total Rows : ";
        int live = 0  , dead = 0 ;
        List<Passenger> passengerListNew ;

        if (!this.passengerList.isEmpty()) {
            passengerListNew = this.passengerList.stream().filter(Passenger :: isSurvived).collect(Collectors.toList());
            live = passengerListNew.size();
            passengerListNew = this.passengerList.stream().filter(passenger -> !passenger.isSurvived()).collect(Collectors.toList());
            dead = passengerListNew.size();
        }

        rows += live + dead +" (" + live + " survived ," + dead + " did not )" ;
        System.out.println(rows);
    }

    public void percentageStatistics () {
        this.stat = new JButton("statistic Button");
        this.stat.setBounds(search.getWidth() + search.getX(), Constants.Y19, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.add(this.stat);
        this.stat.addActionListener(e -> {
            Statistics statistics = new Statistics(this.passengerList);
            callInitialization();
            try {
                double firstPercentage = statistics.survivorPercentageInClass(filterPassengerClass(typeClassOfClass));
                double secondPercentage = statistics.statisticsInSex(genderFiltering(typeClassOfSex));
                List<Double> thirdPercentage = statistics.ageFilterStat();
                List<Double> fourthPercentage = statistics.isFamilyInDeck();
                List<Double> fifthPercentage = statistics.surviveByTicketPrice();
                double sixPercentage = statistics.embarkedStat(typeClassOfEmbarked);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }


    public void callInitialization () {
        this.typeClassOfClass = (String) passengerPClass.getSelectedItem();
        this.typeClassOfSex = (String) passengerSexBox.getSelectedItem();
        this.typeClassOfEmbarked = (String) passengerEmbarked.getSelectedItem();
        this.minId = passengerIdMin.getText();
        this.maxId = passengerIdMax.getText();
        this.name = passengersName.getText();
        this.sibSb = passengerSibAndSb.getText();
        this.parch = passengerPraAndCh.getText();
        this.ticket = passengerTickets.getText();
        this.maxFare = passengerFareMaxim.getText();
        this.minFare = passengerFareMinim.getText();
        this.cabins = passengerCabinsIn.getText();
        this.minAge = passengerAgeMinIm.getText();
        this.maxAge = passengerAgeMixIm.getText();
    }

    public void callFiltering ()  throws IOException {
        filterPassengerClass(typeClassOfClass);
        genderFiltering(typeClassOfSex);
        filterPassengerEmbark(typeClassOfEmbarked);
        idRangeFiltering(minId, maxId);
        findName(name);
        filterSibSb(sibSb);
        filterParch(parch);
        filterTicket(ticket);
        rangePriceFiltering(minFare, maxFare);
        filterCabin(cabins);
        ageFilter(minAge, maxAge);
    }
}
