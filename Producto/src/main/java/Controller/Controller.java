package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Producto;
import Service.Producto_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class Controller {
	
	@Autowired
	private Producto_Service productoservice;
	
	@PostMapping("save-producto")
	public boolean saveProducto(@RequestBody Producto producto) {
		 return productoservice.saveProducto(producto);
		
	}
	
	@GetMapping("productos-list")
	public List<Producto> allproductos() {
		 return productoservice.getProductos();
	}
	
	
	@DeleteMapping("delete-producto/{id_producto}")
	public boolean deleteProducto(@PathVariable("id_producto") int id_producto,Producto producto) {
		producto.setId_producto(id_producto);
		return productoservice.deleteProducto(producto);
	}

	@GetMapping("producto/{id_producto}")
	public List<Producto> allproductoByID(@PathVariable("id_producto") int id_producto,Producto producto) {
		 producto.setId_producto(id_producto);
		 return productoservice.getProductoByID(producto);
		
	}
	
	@PostMapping("update-producto/{id_producto}")
	public boolean updateProducto(@RequestBody Producto producto,@PathVariable("id_producto") int id_producto) {
		producto.setId_producto(id_producto);
		return productoservice.updateProducto(producto);
	}
}
