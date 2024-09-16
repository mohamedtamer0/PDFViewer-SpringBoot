# PDF Viewer with Spring Boot

This project is a PDF viewer application built using Spring Boot. It allows users to upload, view, and delete PDF files. The application provides a simple interface for managing PDF files and demonstrates how to handle file uploads and downloads in a Spring Boot application.

## Features

- **Upload PDFs**: Users can upload PDF files to the server.
- **View PDFs**: Uploaded PDFs can be viewed directly in the browser.
- **Delete PDFs**: Users can delete PDFs from the server.

## Technologies Used

- **Spring Boot**: For building the backend of the application.
- **Thymeleaf**: For rendering HTML views.
- **Bootstrap**: For styling the web pages.
- **AOS**: For animations on scroll.

## Getting Started

### Prerequisites

- JDK 11 or higher
- Maven
- Git

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/mohamedtamer0/PDFViewer-SpringBoot.git
    ```

2. Navigate to the project directory:

    ```bash
    cd PDFViewer-SpringBoot
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    mvn spring-boot:run
    ```

5. Open your browser and go to `http://localhost:8080/pdf/upload` to start using the application.

## Usage

- **Upload PDF**: Use the upload form on the `/pdf/upload` page to upload PDF files.
- **View PDF**: Click on the "View" button next to a PDF in the list to open it in a new tab.
- **Delete PDF**: Click on the "Delete" button next to a PDF to remove it from the server.

## Folder Structure

- `src/main/java/com/tamer/pdfviewer/controller`: Contains the controllers handling HTTP requests.
- `src/main/java/com/tamer/pdfviewer/dao`: Contains the repository interfaces for data access.
- `src/main/java/com/tamer/pdfviewer/service`: Contains the service classes with business logic.
- `src/main/resources/templates`: Contains Thymeleaf HTML templates.
- `src/main/resources/static/css`: Contains static CSS files for styling.

## Contributing

If you want to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push the branch (`git push origin feature/YourFeature`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

If you have any questions or feedback, please feel free to reach out.

- **Author**: Mohamed Tamer
- **GitHub**: [mohamedtamer0](https://github.com/mohamedtamer0)

