package com.example.domain.models

data class GithubUser(
	val gistsUrl: String,
	val reposUrl: String,
	val followingUrl: String,
	val starredUrl: String,
	val login: String,
	val followersUrl: String,
	val type: String,
	val url: String,
	val subscriptionsUrl: String,
	val receivedEventsUrl: String,
	val avatarUrl: String,
	val eventsUrl: String,
	val htmlUrl: String,
	val siteAdmin: Boolean,
	val id: Int,
	val gravatarId: String,
	val nodeId: String,
	val organizationsUrl: String
)
