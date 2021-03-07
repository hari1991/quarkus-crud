package in.hkb.samples.quarkus;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public class Employee {
	private int id;
	private String name;
	private String address;
	private String company;
	private double salary;
}
