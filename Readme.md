#Meetings API

`mutation createPerson {  createPerson(person:{
firstName: "Organizer",
lastName: "Admin",
email: "ghi@jkl.com",
phoneNumber: "+91919191919191"
}){
id
}}`

`mutation createPerson {  createPerson(person:{
firstName: "Invitee",
lastName: "User",
email: "abc@def.com",
phoneNumber: "+91919191919192"
}){
id
}}`

`mutation createMeeting {  createMeeting(meeting:{
startsAt: 1632123084000,
endsAt: 1632126684000,
organizerID: "930c0af7-7b2a-41c6-a54e-4005bc40f814",
invitees: ["e6689820-72c3-4d1d-ac54-cc03663d712f"]
}){
id
}}`

"82336033-4529-41e5-ad7d-7b9f33d5da4e"

`query getMeetings {
getMeetings{
id,
startsAt,
endsAt,
organizer{
id,
firstName,
lastName,
email,
phoneNumber
},
invitees{
id,
firstName,
lastName,
email,
phoneNumber
}
}
}`

