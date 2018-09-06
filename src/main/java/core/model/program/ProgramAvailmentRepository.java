package core.model.program;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	protected String getEntityName() {
		return ProgramAvailment.ENTITY_NAME;
	}

}
