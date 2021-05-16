package org.yjy.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yjy.com.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
