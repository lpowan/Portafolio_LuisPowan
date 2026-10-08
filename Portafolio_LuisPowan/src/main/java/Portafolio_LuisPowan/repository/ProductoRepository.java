/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Portafolio_LuisPowan.repository;

import Portafolio_LuisPowan.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author ltgpo
 */
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
    public List<Producto> findByActivoTrue();
}
