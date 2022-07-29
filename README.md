# vk-technical-task

For run tests using the 'mvn clean test' command with next parameters:

-Dvk.sandboxName (E.g. https://vk.com)
-Dvk.login
-Dvk.password

Example: mvn clean test -Dvk.sandboxName=https://vk.com -Dvk.login=user_login -Dvk.password=user_password

For create allure report using:

mvn allure:serve 
