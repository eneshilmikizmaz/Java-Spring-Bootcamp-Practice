package com.isbasi.repository;

import com.isbasi.dto.EmailDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailDto,Integer> {
}
