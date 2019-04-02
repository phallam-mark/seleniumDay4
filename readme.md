**TestNG / Selenium / Maven Tests** </br>

1. **AssertTest** -> TestNG assertions

2. **CalorieCalcExcelHTTestCase.java** -> using ExcelUtils.java to read test data from a spreadsheet. Also read properties from a .properties file

3. **CalorieCalcHTTestCase.java** -> read test data from a hash table. Also read properties from a .properties file

4. **CalorieCalcPageTestCase.java** -> using page object model

5. **CalorieCalcTestCase.java** -> basic TestNG/Selenium test including radio buttons

6. **CaptureScreenshot.java** -> TestNG/Selenium test that captures screenshots. requires Apache Commons IO 2.6 binary a separate package (this is for outputting the screenshot to a file)

7. **Drag_Drop_HandlingFrames.java** -> for pages containing frames - you can access elements in the frame only once you have switched control to the frame. to do this, you can pass either a frame element, frame index or frame name (eg: https://jqueryui.com/droppable - the draggable boxes are contained within a frame). You can identify an iframe in HTML by tag <iframe src=...>

8. **HandleAjax.java** -> TestNG / Selenium test that includes auto-suggest lists from text boxes (eg: searching on Google.com)

9. **HeadlessTest.java** -> Headless Browser - helps to speed the execution process of a suite. Achieved by not using the GUI -> the code will execute and you can see execution steps and result in the console but not the GUI component. Requires the following	libraries: 'htmlunit', 'htmlunit-driver', 'selenium-api', 'selenium-support'

10. 