package com.zharfan.learnfeature.data.response

import com.google.gson.annotations.SerializedName

data class Company(

	@field:SerializedName("bs")
	val bs: String,

	@field:SerializedName("catchPhrase")
	val catchPhrase: String,

	@field:SerializedName("name")
	val name: String
)