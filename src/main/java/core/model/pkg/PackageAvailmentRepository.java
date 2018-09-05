package core.model.pkg;

import java.util.List;

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
		Criteria criteria = getSession().createCriteria(PackageAvailment.class);
		criteria.add(Restrictions.eq("member.id", memberId));
		criteria.addOrder(Order.desc("date"));
		return criteria.list();
	}

	@Override
	protected String getEntityName() {
		return Package.ENTITY_NAME;
	}

}
