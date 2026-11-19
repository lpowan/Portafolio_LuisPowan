/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Portafolio_LuisPowan.repository;

import Portafolio_LuisPowan.domain.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author ltgpo
 */



public interface RolRepository extends JpaRepository<Rol, Integer> {
    public Optional<Rol> findByRol(String rol);
}