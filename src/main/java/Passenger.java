public class Passenger {
    private int passengerId;
    private boolean survived;
    private int pClass;
    private String name;
    private String sex;
    private double age;
    private String sibSp;
    private String parch;
    private String ticket;
    private double fare;
    private String cabin;
    private String embarked;

    //Constructor
    public Passenger (String data) {
        String[] dataArray = data.split(",");
        dataArray = toFixArrayStr(dataArray);
        passengerId = Integer.parseInt(dataArray[0]);
        switch (dataArray[1]){
            case "1":
                survived = true;
                break;
            case "0":
                survived = false;
        }
        pClass = Integer.parseInt(dataArray[2]);
        name = dataArray[3];
        sex = dataArray[4];
        if (dataArray[5] == null || dataArray[5].isEmpty()){
            age = 0;
        } else {
            age = Double.parseDouble(dataArray[5]);
        }

        sibSp = dataArray[6];
        parch = dataArray[7];
        ticket = dataArray[8];
        fare = Double.parseDouble(dataArray[9]);
        if (dataArray[10] == null) {
            cabin = "";
        } else  {
            cabin = dataArray[10];
        }

        if (dataArray.length < 12 ){
            this.embarked = "";
        } else {
            embarked = dataArray[11];
        }
    }

    // formation for name From "Last First to First Last"
    public String formattedName (String name) {
        String fixName;
        String lastName = " ";
        String firstName = "";

        for (int i = 0; i < name.length() - 1; ++i) {
            if (name.charAt(i) != ','){
                lastName += name.charAt(i);
            } else while (name.charAt(i) != '.')
                ++ i;

            if (name.charAt(i) == '.') {
                for (int j = i+1; j < name.length() ; ++ j) {
                    firstName += name.charAt(j);
                }
                break;
            }
        }
        fixName = firstName + lastName ;
        return fixName;
    }

    public String[] toFixArrayStr (String[] str) {
        String[] stringsNew = new String[str.length-1];
        int counter = 0 ;
        for (int i = 0; i < str.length ; ++ i) {
            if (i == 3) {
                str[i] = formattedName(str[i] + "," + str[i+1]);
            }
            if (i != 4) {
                stringsNew[counter] = str[i];
                counter ++;
            }
        }
        return stringsNew;
    }

    public int getPassengerId () {
        return passengerId;
    }

    public void setPassengerId (int pId) {
        if (passengerId > 0 && passengerId < 849){
            passengerId = pId;
        } else {
            passengerId = 0;
        }
    }

    public boolean isSurvived () {
        return survived;
    }

    public void setSurvived (boolean survived) {
        this.survived = survived;
    }

    public int getpClass () {
        return pClass;
    }

    public void setpClass (int pclass) {
        this.pClass = pclass;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getSex () {
        return sex;
    }

    public void setSex (String sex) {
        this.sex = sex;
    }

    public double getAge () {
        return age;
    }

    public void setAge (double age) {
        this.age = age;
    }

    public String getSibSp () {
        return sibSp;
    }

    public void setSibSp (int sibSp) {
        this.sibSp = String.valueOf(sibSp);
    }

    public String getParch () {
        return parch;
    }

    public void setParch (int parch) {
        this.parch = String.valueOf(parch);
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket (String ticket) {
        this.ticket = ticket;
    }

    public double getFare () {return fare;}

    public void setFare (double Fare) {
        if (fare > 93.5 && fare >= 0) {
            this.fare = Fare ;
        } else  {
            fare = -1.0;
        }
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", survived=" + survived +
                ", pClass=" + pClass +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", sibSp='" + sibSp + '\'' +
                ", parch='" + parch + '\'' +
                ", ticket='" + ticket + '\'' +
                ", fare=" + fare +
                ", cabin='" + cabin + '\'' +
                ", embarked='" + embarked + '\'' +
                '}';
    }
}
