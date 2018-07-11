package de.sci.backend.smartcarinsurancebackend;

import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleDocumentImageProcessor {


    public RegexParser.CarData processImage(byte[] imageAsByteArray) {

        RegexParser.CarData data = new RegexParser.CarData();

        try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {

            ByteString imgBytes = ByteString.copyFrom(imageAsByteArray);

            // Builds the image annotation request
            List<AnnotateImageRequest> requests = new ArrayList<>();
            Image img = Image.newBuilder().setContent(imgBytes).build();
            Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
            AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
                    .addFeatures(feat)
                    .setImage(img)
                    .build();
            requests.add(request);

            // Performs label detection on the image file
            BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            /*Arrays.stream(responses.get(0).getTextAnnotationsList().get(0).getDescription().split
                    ("\n")).forEach(e -> System.out.println(e));

            String[] result = responses.get(0).getTextAnnotationsList().get(0).getDescription().split
                    ("\n")[2].split(" ");
            */

            data = RegexParser.parse(responses.get(0).getTextAnnotationsList());
            return data;
        }catch (Exception e ) {
            System.out.println(e.getStackTrace());
            return data;
        }
    }
}
