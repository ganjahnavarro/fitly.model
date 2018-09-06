package core.model.pkg;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.repository.AbstractRepository;

@Repository
@Transactional
public class PackageAvailmentRepository extends AbstractRepository<PackageAvailment> {

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
			.filter(item -> item.getSessionsCount() >= item.getSessionsRemaining())
			.collect(Collectors.toList());
		
	}

	@Override
	protected String getEntityName() {
		return Package.ENTITY_NAME;
	}

}
