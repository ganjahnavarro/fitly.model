package core.model.program;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.report.ProgramPurchaseSummary;
import core.report.SalesReport;
import core.repository.AbstractRepository;

@Repository
@Transactional
public class ProgramAvailmentRepository extends AbstractRepository<ProgramAvailment> {

	@SuppressWarnings("unchecked")
	public List<ProgramAvailment> findMemberProgramAvailments(Long memberId) {
		Criteria criteria = getDefaultCriteria();
		criteria.add(Restrictions.eq("member.id", memberId));
		criteria.addOrder(Order.desc("startDate"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ProgramAvailment> findAvailableProgramAvailments(Long memberId, Date date) {
		Criteria criteria = getDefaultCriteria();
		
		criteria.add(Restrictions.eq("member.id", memberId));
		criteria.add(Restrictions.le("startDate", date));
		criteria.add(Restrictions.ge("endDate", date));

		criteria.addOrder(Order.asc("startDate"));
		criteria.addOrder(Order.asc("id"));
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ProgramPurchaseSummary> findProgramPurchaseSummaries() {
		String queryString = "select "
				+ "new " + ProgramPurchaseSummary.class.getName()
				+ "(o.availedProgram, count(o.id)) from "
				+ ProgramAvailment.ENTITY_NAME + " o "
				+ "group by o.availedProgram "
				+ "order by count(o.id) desc";
	
		Query query = getSession().createQuery(queryString);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<SalesReport> findSalesReport(Date startDate, Date endDate) {
		String queryString = "select "
				+ "new " + SalesReport.class.getName()
				+ "(o.startDate, o.member, 'Program Availments', o.price) from "
				+ ProgramAvailment.ENTITY_NAME + " o where o.deleted = false";
		
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
		return ProgramAvailment.ENTITY_NAME;
	}

}
