package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Product;
import net.skhu.model.Pagination;

public interface ProductRespository  extends JpaRepository<Product, Integer> {

    public default List<Product> findAll(Pagination pagination) {
        Page<Product> page = this.findAll(PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    Page<Product> findByCategoryId(int categoryId, Pageable pageable);
    Page<Product> findByTitleStartsWith(String title, Pageable pageable);
    List<Product> findByJumoonCustomerId(int id);

    public default List<Product> findByCategoryId(Pagination pagination) {
        if (pagination.getCi() == 0) return findAll(pagination);
        Page<Product> page = this.findByCategoryId(pagination.getCi(),
                PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }


    public default List<Product> findByTitleStartsWith(Pagination pagination){
    	if (pagination.getTt() == "") return findAll(pagination);
    	 String sn = String.valueOf(pagination.getTt());
    	Page<Product> page = this.findByTitleStartsWith(sn,
    			PageRequest.of(pagination.getPg() - 1, pagination.getSz(), Sort.Direction.ASC, "id"));
    	pagination.setRecordCount((int)page.getTotalElements());
    	return page.getContent();
     }
}

