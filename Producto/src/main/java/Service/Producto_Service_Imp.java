package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Producto_DAO;
import Model.Producto;

@Service
@Transactional
public class Producto_Service_Imp implements Producto_Service {
 
	@Autowired
	private Producto_DAO productodao;
	
	@Override
	public boolean saveProducto(Producto producto) {
		return productodao.saveProducto(producto);
	}

	@Override
	public List<Producto> getProductos() {
		return productodao.getProductos();
	}

	@Override
	public boolean deleteProducto(Producto producto) {
		return productodao.deleteProducto(producto);
	}

	@Override
	public List<Producto> getProductoByID(Producto producto) {
		return productodao.getProductoByID(producto);
	}

	@Override
	public boolean updateProducto(Producto producto) {
		return productodao.updateProducto(producto);
	}
}
