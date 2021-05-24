import javax.naming.CommunicationException;
import javax.xml.crypto.Data;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnectieErrorDialog databaseConnectieErrorDialog = new DatabaseConnectieErrorDialog();

        Monitoringcomponent pfSense1 = new Monitoringcomponent("pfSense","Firewall", 99.998, 4000, "192.168.1.26");
        Monitoringcomponent db1 = new Monitoringcomponent("DB1", "HAL9002DB", 95, 7700, "192.168.1.26");
        Monitoringcomponent db2 = new Monitoringcomponent("DB2", "HAL9002DB", 95, 7700, "192.168.1.26");
        Monitoringcomponent ws1 = new Monitoringcomponent("WS1", "HAL9002W", 90, 3200, "192.168.1.131");
        Monitoringcomponent ws2 = new Monitoringcomponent("WS2", "HAL9002W", 90, 3200, "192.168.1.131");

//        Monitoringcomponent db1 = new Monitoringcomponent("Database1", "database", "Online", 90, 80, 256, 20, 90.00);
//        Monitoringcomponent db2 = new Monitoringcomponent("Database2","database" ,"Offline", 40, 45, 315, 20, 90.00);
//        Monitoringcomponent db3 = new Monitoringcomponent("Database3", "database", "Online", 80, 80, 256, 20, 90.00);
//        Monitoringcomponent db4 = new Monitoringcomponent("Database4", "database","Online", 120, 80, 256, 20, 95.00);
//        Monitoringcomponent ws1 = new Monitoringcomponent("Webserver1", "database","Online", 120, 80, 256, 50, 90.00);
//        Monitoringcomponent ws2 = new Monitoringcomponent("Webserver2", "webserver","Offline", 120, 80, 312, 50, 90.00);
//        Monitoringcomponent ws3 = new Monitoringcomponent("Webserver3", "webserver","Online", 60, 120, 256, 50, 90.00);
//        Monitoringcomponent ws4 = new Monitoringcomponent("Webserver4","webserver","Online", 120, 80, 256, 50, 90.00);
//        Monitoringcomponent ws5 = new Monitoringcomponent("Webserver5","webserver","Offline", 120, 80, 256, 50, 80.00);
//        Monitoringcomponent pfSense1 = new Monitoringcomponent("pfSense1","firewall","Online", 2000, 30, 1256, 120, 99.99);


        Groep firewall = new Groep("Firewall", 99.97);
        firewall.componenten.add(pfSense1);

        Groep db = new Groep("Databaseservers", 99.98);
        db.componenten.add(db1);
        db.componenten.add(db2);
        //db.componenten.add(db3);
        //db.componenten.add(db4);

        Groep ws = new Groep("Webservers", 99.99);
        ws.componenten.add(ws1);
        ws.componenten.add(ws2);
        //ws.componenten.add(ws3);
        //ws.componenten.add(ws4);
        //ws.componenten.add(ws5);

        Monitoringnetwerk netwerk1 = new Monitoringnetwerk("Netwerk 1", 200, 99.99);
        netwerk1.groepen.add(firewall);
        netwerk1.groepen.add(db);
        netwerk1.groepen.add(ws);

        Monitoringnetwerk netwerk2 = new Monitoringnetwerk("Netwerk 2", 350, 90);
        Monitoringnetwerk netwerk4 = new Monitoringnetwerk("Netwerk 4", 350, 90);
        Monitoringnetwerk netwerk6 = new Monitoringnetwerk("Netwerk 6", 350, 90);
        Monitoringnetwerk netwerk7 = new Monitoringnetwerk("Netwerk 7", 350, 90);
//        MonitoringFrame monitoringFrame1 = new MonitoringFrame(netwerk1);

        Ontwerpcomponent db5 = new Ontwerpcomponent("Database5", "database", 100,   99.90);
        Ontwerpcomponent db6 = new Ontwerpcomponent("Database6","database" ,400,  98.00);
        Ontwerpcomponent db7 = new Ontwerpcomponent("Database7", "database", 300,  99.98);
        Ontwerpcomponent db8 = new Ontwerpcomponent("Database8", "database",120,   99.96);
        Ontwerpcomponent ws6 = new Ontwerpcomponent("Webserver6", "database",930,   99.93);
        Ontwerpcomponent ws7 = new Ontwerpcomponent("Webserver7", "webserver",125,   99.99);
        Ontwerpcomponent ws8 = new Ontwerpcomponent("Webserver8", "webserver", 980,  99.91);
        Ontwerpcomponent ws9 = new Ontwerpcomponent("Webserver9","webserver", 470,  99.89);
        Ontwerpcomponent ws10 = new Ontwerpcomponent("Webserver10","webserver", 390,   90.00);
        Ontwerpcomponent pfSense2 = new Ontwerpcomponent("pfSense2","firewall",230, 99.99);

//        Ontwerpcomponent db9 = new Ontwerpcomponent("Database9", "HAL9001DB", "database", 100, 99.0);


        Groep dbOntwerpComponenten = new Groep("OntwerpDatabaseservers", 99.99);
        dbOntwerpComponenten.componenten.add(db5);
        dbOntwerpComponenten.componenten.add(db6);
        dbOntwerpComponenten.componenten.add(db7);
        dbOntwerpComponenten.componenten.add(db8);

        Groep wsOntwerpComponenten = new Groep("OntwerpWebservers", 99.98);
        wsOntwerpComponenten.componenten.add(ws6);
        wsOntwerpComponenten.componenten.add(ws7);
        wsOntwerpComponenten.componenten.add(ws8);
        wsOntwerpComponenten.componenten.add(ws9);
        wsOntwerpComponenten.componenten.add(ws10);

        Groep firewallOntwerpComponent = new Groep("OntwerpFirewall", 99.99);
        firewallOntwerpComponent.componenten.add(pfSense2);

        Ontwerpnetwerk netwerk3 = new Ontwerpnetwerk("Ontwerpnetwerk uit main", 999, 99.99, 99.98);
        netwerk3.groepen.add(dbOntwerpComponenten);
        netwerk3.groepen.add(wsOntwerpComponenten);
        netwerk3.groepen.add(firewallOntwerpComponent);
        netwerk3.setCorrecteKostenEnBeschikbaarheid();

        Ontwerpnetwerk netwerk5 = new Ontwerpnetwerk("Netwerk 5", 999, 99.99, 99.98);

        OntwerpFrame ontwerpFrame = new OntwerpFrame(netwerk3);

        Ontwerpnetwerk netwerk125 = new Ontwerpnetwerk("netwerk125");
        netwerk125.groepen.add(dbOntwerpComponenten);
        netwerk125.groepen.add(wsOntwerpComponenten);
        netwerk125.groepen.add(firewallOntwerpComponent);
        netwerk125.setCorrecteKostenEnBeschikbaarheid();
    }
}