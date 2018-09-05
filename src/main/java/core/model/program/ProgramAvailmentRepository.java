package core.model.program;

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
		Criteria criteria = getSession().createCriteria(ProgramAvailment.class);
		criteria.add(Restrictions.eq("member.id", memberId));
		criteria.addOrder(Order.desc("date"));
		return criteria.list();
	}

	@Override
	protected String getEntityName() {
		return ProgramAvailment.ENTITY_NAME;
	}

}
