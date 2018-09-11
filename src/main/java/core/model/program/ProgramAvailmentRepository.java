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

	@Override
	protected String getEntityName() {
		return ProgramAvailment.ENTITY_NAME;
	}

}
