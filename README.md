# Hotel Booking System 🏨

This java program allows users to book into different accommodations in a hotel. An admin can populate the hotel with various types of accommodations. The program was made for the Advanced Programming course project.

## Features 💥
- Heavy OOP structure
- Snack functionality for rooms (including a snack inventory, snack bill, snack consumption and refill)
- Made with gradle so it can be easily built
- Includes test classes to test the functionality of methods at edge cases
- Dynamic & Responsive GUI using JavaFX, FXML, Controllers and CSS
- Full client and server side validations
- All user bookings and accommodations are tracked by email
- Only admins are authorized to add new accommodations

## Installation 🔧

### Requirements
- `git` command line([Windows](https://git-scm.com/download/win) | [Linux](https://git-scm.com/download/linux) | [macOS](https://git-scm.com/download/mac)) installed
- `gradle` (import the gradle project through [IntelliJ](https://www.jetbrains.com/idea/download/?section=windows))

### Instructions
1. Clone the repository
```sh
git clone https://github.com/amenhany/cse231-project.git
```
2. Open the project in IntelliJ CE
3. Open the `build.gradle` file and import the gradle project
4. Run the program through the gradle tasks menu
```sh
gradlew run
```

## How does it work?

1. Login as an admin using the email `admin@hotelbooking.org`

![image](https://github.com/user-attachments/assets/a4a93daa-f4bc-4b46-98d0-d4a03eed9677)

2. Head to My Accommodations and click the Add Accommodation Button

![image](https://github.com/user-attachments/assets/f1876a93-afc0-4118-b3e6-82d568ea934a)

3. Add the appropriate accommodations to populate the Hotel

![image](https://github.com/user-attachments/assets/22584c93-a4ed-47b2-a964-8f2a7dc7cb85)

4. (Optional) Logout and Login again as a normal user

5. Head to New Booking and try booking into one of the accommodations that are available

![image](https://github.com/user-attachments/assets/c043b7da-9ae3-47af-b03e-7a928de02f7d)

6. All the user's previous bookings are listed in the My Bookings page along with the bill, sorted by date

![image](https://github.com/user-attachments/assets/331376a7-2d3b-4509-9948-84139f886ff6)

7. All the accommodations the user checked into will be displayed in the My Accommodations page, sorted by ID

![image](https://github.com/user-attachments/assets/bd7f814b-f062-4933-9944-fcf6368011f6)
