# MightyCourses
Android application to help students organize their schedules/classes

By Mighty Chen, Started May 2017. "Finished" Aug 2017 (after taking many breaks from it)

The idea of this app comes from NinjaCourses.
I self-studied and skipped the second introductory to programming class at school, and wanted to recreate the idea as a means to test myself
on basic coding practices. I created a version of this that was based on pure text and ran only in Eclipse.

When I was being trained to tutor for these classes a semester later, the tutor I was shadowing mentioned to his students that someone that
he knew built a UI and app for a GPA calculator and had a solid 30-users. I was inspired and wanted to do the same.



The app is fully functional and works, but needs some added functionality if I actually want people to use it:

-Better UI design (make it pretty)
-Better user experience
  -Having a way to clear TextViews when you click on them
  -AM/PM button
-Accounting for human error
  -people (like me) are good at make mistakes when they input information. There is currently no way to go back to a previous course if somebody inputs the wrong info.
  -logic errors
      -Start Time must be smaller than End Time
      -Classes can not be at the same time
      -Classes (probably) can not have the same name
-Future functionality
  -Setting a "main schedule" to distinguish between your own schedule and schedule of friends
  -Capability to compare (ideally friends') schedules to current time to determine availability
  -Using SQL database hosted by Azure instead of internal storage, mapping schedules to unique codes so that people can access their friends' schedules with a code
  -Making schedules deletable lol
  -Put it on the PlayStore
