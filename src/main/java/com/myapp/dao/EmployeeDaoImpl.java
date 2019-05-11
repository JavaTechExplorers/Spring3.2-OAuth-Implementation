package com.myapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.myapp.entity.EmployeeEntity;
import com.myapp.service.so.EmployeeSo;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<EmployeeSo> getData(EmployeeSo employeeSo) throws Exception {

		List<EmployeeSo> target = new ArrayList<>();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmployeeEntity> cq = builder.createQuery(EmployeeEntity.class);
		Root<EmployeeEntity> root = cq.from(EmployeeEntity.class);
		cq.select(root);

		List<EmployeeEntity> employeeList = entityManager.createQuery(cq).getResultList();

		if (employeeList != null) {
			for (EmployeeEntity employeeEntity : employeeList) {

				EmployeeSo so = new EmployeeSo();
				so.setEmpName(employeeEntity.getEmpName());
				so.setEmpDesc(employeeEntity.getEmpDesc());
				so.setEmpGender(employeeEntity.getEmpGender());

				target.add(so);
			}
		}
		return target;
	}

	public EmployeeSo save(EmployeeSo employeeSo) throws Exception {

		EmployeeEntity entity = new EmployeeEntity();

		BeanUtils.copyProperties(entity, employeeSo);

		entityManager.persist(entity);

		return employeeSo;
	}

}
