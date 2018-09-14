package core.model.member;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.report.SalesReport;
import core.repository.AbstractRepository;

@Repository
@Transactional
public class MembershipRepository extends AbstractRepository<Membership> {
	
	@SuppressWarnings("unchecked")
	public List<Membership> findMembershipsByMemberId(Long memberId) {
		Criteria criteria = getSession().createCriteria(Membership.class);
		criteria.add(Restrictions.eq("member.id", memberId));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Membership> findAllMemberships() {
		Criteria criteria = getSession().createCriteria(Membership.class);
		criteria.addOrder(Order.desc("startDate"));
		criteria.addOrder(Order.desc("modifiedDate"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<SalesReport> findSalesReport(Date startDate, Date endDate) {
		String queryString = "select "
				+ "new " + SalesReport.class.getName()
				+ "(o.startDate, o.member, 'Memberships', o.amount) from "
				+ Membership.ENTITY_NAME + " o where o.deleted = false";
		
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
		return Membership.ENTITY_NAME;
	}

}
