package core.model.pkg;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.report.PackagePurchaseSummary;
import core.report.SalesReport;
import core.repository.AbstractRepository;

@Repository
@Transactional
public class PackageAvailmentRepository extends AbstractRepository<PackageAvailment> {
	
	public PackageAvailment findByIdWithDetails(Long id) {
		PackageAvailment packageAvailment = (PackageAvailment) getSession().get(PackageAvailment.class, id);
		Hibernate.initialize(packageAvailment.getSessions());
		return packageAvailment;
	}

	@SuppressWarnings("unchecked")
	public List<PackageAvailment> findMemberPackageAvailments(Long memberId) {
		Criteria criteria = getDefaultCriteria();
		criteria.add(Restrictions.eq("member.id", memberId));
		criteria.addOrder(Order.desc("startDate"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<PackageAvailment> findAvailablePackageAvailments(Long memberId, Date date) {
		Criteria criteria = getDefaultCriteria();
		
		criteria.add(Restrictions.eq("member.id", memberId));
		criteria.add(Restrictions.le("startDate", date));
		
		criteria.add(Restrictions.or(
				Restrictions.isNull("endDate"),
				Restrictions.ge("endDate", date)
				));

		criteria.addOrder(Order.asc("startDate"));
		criteria.addOrder(Order.asc("id"));
		
		List<PackageAvailment> packageAvailments = criteria.list();
		
		// Filter by remaining sessions count
		return packageAvailments.stream()
			.filter(item -> item.getSessionsRemaining() > 0)
			.collect(Collectors.toList());
		
	}
	
	@SuppressWarnings("unchecked")
	public List<PackagePurchaseSummary> findPackagePurchaseSummaries() {
		String queryString = "select "
				+ "new " + PackagePurchaseSummary.class.getName()
				+ "(o.availedPackage, count(o.id)) from "
				+ PackageAvailment.ENTITY_NAME + " o "
				+ "group by o.availedPackage "
				+ "order by count(o.id) desc";
	
		Query query = getSession().createQuery(queryString);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<SalesReport> findSalesReport(Date startDate, Date endDate) {
		String queryString = "select "
				+ "new " + SalesReport.class.getName()
				+ "(o.startDate, o.member, 'Package Availments', o.price) from "
				+ PackageAvailment.ENTITY_NAME + " o where o.deleted = false";
		
		if (startDate != null) {
			queryString += " and o.startDate >= :startDate";
		}
		
		if (endDate != null) {
			queryString += " and o.startDate <= :endDate";
		}

		queryString += " order by o.startDate";
		Query query = getSession().createQuery(queryString);
		
		if (startDate != null) {
			query.setParameter("startDate", startDate);
		}
		
		if (endDate != null) {
			query.setParameter("endDate", endDate);
		}

		return query.list();
	}
	
	@Override
	protected String getEntityName() {
		return Package.ENTITY_NAME;
	}

}
