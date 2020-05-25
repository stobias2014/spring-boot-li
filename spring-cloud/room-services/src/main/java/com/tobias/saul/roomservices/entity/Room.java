package com.tobias.saul.roomservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROOM_ID")
	private Long roomId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "ROOM_NUMBER")
	private String roomNumber;
	@Column(name = "BED_INFO")
	private String bedInfo;
	
	public Room() {}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getBedInfo() {
		return bedInfo;
	}

	public void setBedInfo(String bedInfo) {
		this.bedInfo = bedInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bedInfo == null) ? 0 : bedInfo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
		result = prime * result + ((roomNumber == null) ? 0 : roomNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (bedInfo == null) {
			if (other.bedInfo != null)
				return false;
		} else if (!bedInfo.equals(other.bedInfo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (roomId == null) {
			if (other.roomId != null)
				return false;
		} else if (!roomId.equals(other.roomId))
			return false;
		if (roomNumber == null) {
			if (other.roomNumber != null)
				return false;
		} else if (!roomNumber.equals(other.roomNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", name=" + name + ", roomNumber=" + roomNumber + ", bedInfo=" + bedInfo
				+ "]";
	}
	
	
	
}
