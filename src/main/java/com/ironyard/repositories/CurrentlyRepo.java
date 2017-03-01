package com.ironyard.repositories;

import com.ironyard.data.Currently;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by osmanidris on 3/1/17.
 */
public interface CurrentlyRepo extends PagingAndSortingRepository<Currently,Long> {
}
