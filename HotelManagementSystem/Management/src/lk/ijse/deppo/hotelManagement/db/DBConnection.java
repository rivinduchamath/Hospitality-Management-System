package lk.ijse.deppo.hotelManagement.db;;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
    public static String nameq;
    private static Connection connection;
    private static DBConnection dBconnection;


    private DBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelManagement?createDatabaseIfNotExist=true&allowMultiQueries=true","root","1234");
            PreparedStatement show_tables = connection.prepareStatement("SHOW TABLES");
            ResultSet execute = show_tables.executeQuery();
            if(!execute.next()){
                PreparedStatement createTable =
                        connection.prepareStatement("create table guest ( id  varchar(20)  not null primary key, idType  varchar(50)  null, name    varchar(50)  null,email   varchar(50)  null, country varchar(100) null,noPlate varchar(50)  null,total double null);" +
                                " create table banquet (banquetId   varchar(10)    not null primary key,\n" +
                                "  dateAdd     date           null,\n" +
                                "  guestId     varchar(100)   null,\n" +
                                "  chair       int(20)        null,\n" +
                                "  dateBanquet date           null,\n" +
                                "  noOfPeople  int(20)        null,\n" +
                                "  platePrice  decimal(10, 2) null,\n" +
                                "  mealType    varchar(150)   null,\n" +
                                "  submitedBy  varchar(50)    null,\n" +
                                "  discount    double(20, 2)  null,\n" +
                                "  constraint banquet_ibfk_1\n" +
                                "  foreign key (guestId) references guest (id)\n" +
                                ");\n" +
                                "\n" +
                                "create index guestId\n" +
                                "  on banquet (guestId);\n" +
                                "\n" +
                                "create table foodandbev\n" +
                                "(\n" +
                                "  orderid varchar(50)   not null\n" +
                                "    primary key,\n" +
                                "  cusId   varchar(50)   null,\n" +
                                "  total   double(30, 2) null,\n" +
                                "  today   date          null,\n" +
                                "  constraint foodandbev_ibfk_1\n" +
                                "  foreign key (cusId) references guest (id)\n" +
                                ");\n" +
                                "\n" +
                                "create index cusId\n" +
                                "  on foodandbev (cusId);\n" +
                                "\n" +
                                "create table manage\n" +
                                "(\n" +
                                "  currency varchar(150)  not null\n" +
                                "    primary key,\n" +
                                "  price    double(20, 2) null\n" +
                                ");\n" +
                                "\n" +
                                "create table menu\n" +
                                "(\n" +
                                "  id          varchar(50)   not null\n" +
                                "    primary key,\n" +
                                "  price       double(30, 2) null,\n" +
                                "  description varchar(50)   null,\n" +
                                "  qtyOnHand   int(20)       null\n" +
                                ");\n" +
                                "\n" +
                                "create table foodandbevdata\n" +
                                "(\n" +
                                "  id          varchar(50) default '' not null,\n" +
                                "  itemId      varchar(50) default '' not null,\n" +
                                "  description varchar(50)            null,\n" +
                                "  orderqty    int(20)                null,\n" +
                                "  uniteprice  double(30, 1)          null,\n" +
                                "  primary key (id, itemId),\n" +
                                "  constraint foodandbevdata_ibfk_1\n" +
                                "  foreign key (itemId) references menu (id),\n" +
                                "  constraint foodandbevdata_ibfk_2\n" +
                                "  foreign key (id) references foodandbev (orderid)\n" +
                                ");\n" +
                                "\n" +
                                "create index itemId\n" +
                                "  on foodandbevdata (itemId);\n" +
                                "\n" +
                                "create table reservation\n" +
                                "(\n" +
                                "  id       varchar(50) not null\n" +
                                "    primary key,\n" +
                                "  guestId  varchar(50) null,\n" +
                                "  date     date        null,\n" +
                                "  currency varchar(50) null,\n" +
                                "  discount double      null,\n" +
                                "  subTotal double      null,\n" +
                                "  total    double      null,\n" +
                                "  constraint reservation_ibfk_1\n" +
                                "  foreign key (guestId) references guest (id)\n" +
                                ");\n" +
                                "\n" +
                                "create index guestId\n" +
                                "  on reservation (guestId);\n" +
                                "\n" +
                                "create table room\n" +
                                "(\n" +
                                "  no          varchar(20)    not null\n" +
                                "    primary key,\n" +
                                "  type        varchar(150)   null,\n" +
                                "  price       decimal(20, 2) null,\n" +
                                "  catogry     varchar(20)    null,\n" +
                                "  state       varchar(30)    null,\n" +
                                "  clean       varchar(50)    null,\n" +
                                "  date        date           null,\n" +
                                "  avilability tinyint(1)     null\n" +
                                ");\n" +
                                "\n" +
                                "create table reservationdata\n" +
                                "(\n" +
                                "  reservationId varchar(20) default '' not null,\n" +
                                "  roomNo        varchar(20) default '' not null,\n" +
                                "  arivalDate    date                   null,\n" +
                                "  depatureDate  date                   null,\n" +
                                "  mealID        varchar(20)            null,\n" +
                                "  noOfChildren  int(20)                null,\n" +
                                "  noOfAdults    int(20)                null,\n" +
                                "  totalPrice    decimal(20, 2)         null,\n" +
                                "  incharge      varchar(50)            null,\n" +
                                "  primary key (reservationId, roomNo),\n" +
                                "  constraint reservationdata_ibfk_1\n" +
                                "  foreign key (reservationId) references reservation (id),\n" +
                                "  constraint reservationdata_ibfk_2\n" +
                                "  foreign key (roomNo) references room (no),\n" +
                                "  constraint reservationdata_ibfk_3\n" +
                                "  foreign key (mealID) references menu (id)\n" +
                                ");\n" +
                                "\n" +
                                "create index mealID\n" +
                                "  on reservationdata (mealID);\n" +
                                "\n" +
                                "create index roomNo\n" +
                                "  on reservationdata (roomNo);\n" +
                                "\n" +
                                "create table `user`\n" +
                                "(\n" +
                                "  Id       varchar(20) not null\n" +
                                "    primary key,\n" +
                                "  name     varchar(50) null,\n" +
                                "  post     varchar(50) null,\n" +
                                "  password varchar(50) null,\n" +
                                "  age      int         null,\n" +
                                "  date     date        null\n" +
                                ");" +
                                "INSERT INTO manage values('CUEURO',0),('CUUSD',0);\n" +
                                "INSERT INTO user values(1,'chamath','Manager',1234,22,'2020-01-17');" +
                                "\n");

                createTable.execute();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static DBConnection getInstance(){
        return (dBconnection==null)?(dBconnection=new DBConnection()):dBconnection;
    }

    public Connection getConnection(){return connection;}

}