package in.hkb.samples.quarkus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

@ApplicationScoped
public class EmployeeDAO {
	
	@Inject
	@DataSource("mysql")
	AgroalDataSource mysqlDataSource;

	public Employee createNewEmployee(Employee employee) throws SQLException 
	{
		PreparedStatement ps = mysqlDataSource.getConnection().prepareStatement("INSERT INTO `test`.`employee` (`name`, `address`, `company`, `salary`) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, employee.getName());
		ps.setString(2, employee.getAddress());
		ps.setString(3, employee.getCompany());
		ps.setDouble(4, employee.getSalary());
		ps.executeUpdate();
		
		ResultSet resultSet = ps.getGeneratedKeys();
		if(resultSet.next())
		{
			employee.setId(resultSet.getInt(1));
		}
		resultSet.close();
		ps.close();
		return employee;
	}
	
}
