package product;

public class Product {
 private int id;
 private String name;
 private String type;
private  double cost;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
public Product(int id, String name, String type, double cost) {
	this.id = id;
	this.name = name;
	this.type = type;
	this.cost = cost;
}
Product(String name,int id){
	this.id=id;
	this.name=name;
}
Product(double cost,int id){
	this.cost=cost;
	this.id=id;
}
Product(int id,String type){
	this.id=id;
	this.type=type;
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", type=" + type + ", cost=" + cost + "]";
}

 
}
