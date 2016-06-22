package Entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "client")
public class Client {
    private int id;
    private String name;
    private String profession;
}
