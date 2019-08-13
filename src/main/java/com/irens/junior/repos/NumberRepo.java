package com.irens.junior.repos;

import com.irens.junior.domain.Number;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;


public interface NumberRepo extends CrudRepository <Number, BigInteger> {
}
