package com.example.medicalpharmacy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.entities.Doctor;
import com.example.entities.Inventory;
import com.example.entities.Medicine;
import com.example.entities.Order;
import com.example.entities.Pharmacy;
import com.example.services.DoctorService;
import com.example.services.InventoryService;
import com.example.services.MedicineService;
import com.example.services.OrderService;
import com.example.services.PharmacyService;

public class Test {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/jdbcconfig.xml");

		MedicineService medicine = context.getBean("medicineDao", MedicineService.class);
		DoctorService doctor = context.getBean("doctorDao", DoctorService.class);
		OrderService order = context.getBean("orderDao", OrderService.class);
		PharmacyService pharmacy = context.getBean("pharmacyDao", PharmacyService.class);
		InventoryService inventory = context.getBean("inventoryDao", InventoryService.class);

		try {
			boolean condition = true;
			while (condition) {
				System.out.println("1.Medicine");
				System.out.println("2.Doctor");
				System.out.println("3.Order");
				System.out.println("4.Pharmacy");
				System.out.println("5.Inventory");
				System.out.println("Enter any key to exit");

				BufferedReader get = new BufferedReader(new InputStreamReader(System.in));
				int choice = Integer.parseInt(get.readLine());
				
				switch (choice) {
				case 1:
					System.out.println("1.Create Medicine");
					System.out.println("2.Search Medicine by name");
					System.out.println("3.Search Medicine by brand");
					System.out.println("4.Delete Medicine");
					System.out.println("Enter any key to go back to main menu");

					int medicineChoice = Integer.parseInt(get.readLine());
					switch (medicineChoice) {
					case 1:
						Medicine med = new Medicine();
						System.out.println("Enter id:");
						med.setId(Integer.parseInt(get.readLine()));
						System.out.println("Enter name:");
						med.setName(get.readLine());
						System.out.println("Enter Brand:");
						med.setBrand(get.readLine());

						int rows = medicine.create(med);
						System.out.println(rows + " number of rows affected");
						break;
					case 2:
						System.out.println("Enter medicine name: ");
						String medicineName = get.readLine();
						List<Medicine> name = medicine.searchByName(medicineName);
						for (Medicine m : name) {
							System.out.println(m);
						}
						break;
					case 3:
						System.out.println("Enter medicine brand: ");
						String medicineBrand = get.readLine();
						List<Medicine> brand = medicine.searchByBrand(medicineBrand);
						for (Medicine m : brand) {
							System.out.println(m);
						}
						break;
					case 4:
						System.out.println("Enter medicine id: ");
						int drows = medicine.delete(Integer.parseInt(get.readLine()));
						System.out.println(drows + " number of rows affected");
						break;
					default:
						break;
					}
					break;

				case 2:
					System.out.println("1.Create Doctor");
					System.out.println("2.Search Doctor");
					System.out.println("3.Delete Doctor");
					System.out.println("Enter any key to go back to main menu");

					int doctorChoice = Integer.parseInt(get.readLine());
					switch (doctorChoice) {
					case 1:
						Doctor doc = new Doctor();
						System.out.println("Enter id:");
						doc.setId(Integer.parseInt(get.readLine()));
						System.out.println("Enter first name:");
						doc.setFirstName(get.readLine());
						System.out.println("Enter last name:");
						doc.setLastName(get.readLine());
						
						int rows = doctor.create(doc);
						System.out.println(rows + " number of rows affected");
						break;
					case 2:
						System.out.println("Enter doctor name: ");
						String doctorName = get.readLine();
						List<Doctor> name = doctor.search(doctorName);
						for (Doctor d : name) {
							System.out.println(d);
						}
						break;
					case 3:
						System.out.println("Enter doctor id: ");
						int drows = doctor.delete(Integer.parseInt(get.readLine()));
						System.out.println(drows + " number of rows affected");
						break;
					default:
						break;
					}
					break;

				case 3:
					System.out.println("1.Make a Order");
					System.out.println("2.Display Pending Orders");
					System.out.println("3.Complete Order");
					System.out.println("Enter any key to go back to main menu");
					int orderChoice = Integer.parseInt(get.readLine());
					switch (orderChoice) {
					case 1:
						Order or = new Order();
						System.out.println("Enter order id:");
						or.setId(Integer.parseInt(get.readLine()));
						
						System.out.println("Enter order quantity:");
						or.setQuantity(Integer.parseInt(get.readLine()));
						
						System.out.println("Enter medicine id:");
						Medicine orderMed = new Medicine();
						orderMed.setId(Integer.parseInt(get.readLine()));
						or.setMedicine(orderMed);
						
						Pharmacy orPharmacy = new Pharmacy();
						orPharmacy.setId(1);
						or.setPharmacy(orPharmacy);
						
						int rows = order.makeOrder(or);
						System.out.println(rows + " number of rows affected");
						break;
					case 2:
						List<Order> pending = order.pendingOrders();
						for (Order o : pending) {
							System.out.println(o);
						}
						break;
					case 3:
						System.out.println("Enter order id:");
						int orderId = Integer.parseInt(get.readLine());
						int complete = order.completeOrder(orderId);
						System.out.println(complete + " number of rows affected");
						break;
					default:
						break;
					}
					break;

				case 4:
					System.out.println("1.Create Pharmacy");
					System.out.println("2.Show Pharmacy Details");
					System.out.println("3.Delete Pharmacy");
					System.out.println("4.Show all orders");
					System.out.println("Enter any key to go back to main menu");

					int pharmacyChoice = Integer.parseInt(get.readLine());
					switch (pharmacyChoice) {
					case 1:
						Pharmacy pharma = context.getBean("pharmacy", Pharmacy.class);
						int rows = pharmacy.create(pharma);
						System.out.println(rows + " number of rows affected");
						break;
					case 2:
						System.out.println("Enter pharmacy id: ");
						Pharmacy ph1 = pharmacy.information(Integer.parseInt(get.readLine()));
						System.out.println(ph1);
						break;
					case 3:
						System.out.println("Enter pharmacy id: ");
						int drows = pharmacy.delete(Integer.parseInt(get.readLine()));
						System.out.println(drows + " number of rows affected");
					case 4:
						System.out.println("Enter pharmacy id: ");
						List<Order> orders = pharmacy.showAllOrders(Integer.parseInt(get.readLine()));
						for(Order or : orders) {
							System.out.println(or);
						}
						break;
					default:
						break;
					}
					break;

				case 5:
					System.out.println("1.Add Medicine in Inventory");
					System.out.println("2.Show Medicines in Inventory");
					System.out.println("Enter any key to go back to main menu");

					int inventoryChoice = Integer.parseInt(get.readLine());
					switch (inventoryChoice) {
					case 1:
						Inventory inv = new Inventory();
						System.out.println("Enter id:");
						inv.setId(Integer.parseInt(get.readLine()));
						
						System.out.println("Enter medicine id:");
						Medicine inventoryMed = new Medicine();
						inventoryMed.setId(Integer.parseInt(get.readLine()));
						inv.setMedicine(inventoryMed);
						
						System.out.println("Enter stock:");
						inv.setStock(Integer.parseInt(get.readLine()));
						
						Pharmacy invPharmacy = new Pharmacy();
						invPharmacy.setId(1);
						inv.setPharmacy(invPharmacy);
						
						int rows = inventory.create(inv);
						System.out.println(rows + " number of rows affected");
						break;
					case 2:
						List<Inventory> medicines = inventory.medicineList();
						for (Inventory i : medicines) {
							System.out.println(i);
						}
						break;
					default:
						break;
					}
					break;

				default:
					condition = false;
					System.out.println("Have a nice day");
					break;
				}
			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			context.close();
		}
	}
}
