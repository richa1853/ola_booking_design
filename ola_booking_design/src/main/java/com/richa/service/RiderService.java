package com.richa.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.richa.entity.Rider;
import com.richa.exceptions.RiderAlreadyExistsException;
import com.richa.exceptions.RiderNotFoundException;

@Service
public class RiderService {
	HashMap<String, Rider> riders = new HashMap<>();

	public void registerRider(Rider newRider) {
		if (riders.containsKey(newRider.getId())) {
			throw new RiderAlreadyExistsException();
		} else {
			riders.put(newRider.getId(), newRider);
		}

	}

	public Rider getRider(String riderId) {
		if (!riders.containsKey(riderId)) {
			throw new RiderNotFoundException();
		}
		return riders.get(riderId);
	}

}
