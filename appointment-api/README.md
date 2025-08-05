# This is a README file for the appointment-api project.

## Appointment API

This project is a simple Spring Boot application that can be deployed to Google Cloud Run

## Prerequisites

- Java 17 or higher
- Maven
- Google Cloud SDK installed and configured
- A Google Cloud project created
- Docker installed
- Firestore database set up in your Google Cloud project

## Setup Instructions

Set up the environment variables for your Google Cloud project:

```bash
export PROJECT_ID=your-project-id
export GOOGLE_CLOUD_REGION=your-region
```

## Build and Deploy

To build the project and deploy it to Google Cloud Run, follow these steps:

1. Build the project using Maven:
   ```bash
   mvn clean package
   ```
2. Build the Docker image:
   ```bash
   docker build -t gcr.io/$PROJECT_ID/appointment-api .
   ```
3. Push the Docker image to Google Container Registry:
   ```bash
   docker push gcr.io/$PROJECT_ID/appointment-api
   ```
4. Deploy the Docker image to Google Cloud Run:

   ```bash
   gcloud run deploy appointment-api \
     --image gcr.io/$PROJECT_ID/appointment-api \
     --platform managed \
     --region $GOOGLE_CLOUD_REGION \
     --allow-unauthenticated \
     --project $PROJECT_ID
   ```

   or if you want to deploy with authentication:

   ```bash
    gcloud builds submit .
   ```

If you notice warning

````
 Setting IAM policy failed, try "gcloud beta run services add-iam-policy-binding --region=us-central1 --member=allUsers --role=roles/run.invoker appt-api"
    ```
    you can run the command suggested in the warning to allow unauthenticated invocations:

    ```bash
    gcloud beta run services add-iam-policy-binding appointment-api \
      --region $GOOGLE_CLOUD_REGION \
      --member=allUsers \
      --role=roles/run.invoker
    ```

## Usage

Once deployed, you can access the API at the URL provided by Google Cloud Run. You can use tools like Postman or curl to interact with the API endpoints.

## Endpoints

- `GET /appointments`: Retrieve a list of appointments.
- `POST /appointments`: Create a new appointment.
- `GET /appointments/{id}`: Retrieve a specific appointment by ID.
````
