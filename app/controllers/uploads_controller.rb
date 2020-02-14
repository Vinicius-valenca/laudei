class UploadsController < ApplicationController
  skip_before_action :verify_authenticity_token  
    def create
      logger.info "Processing the request..."

        
           logger.info params[:file].original_filename
           #@upload
          logger.info "File"

          UploadMailer.new_upload_email(current_user,params[:file]).deliver


          # these two following comments are some useful methods to debug
          # abort pic.class.inspect -> It is similar to var_dump($variable) in PHP. 
          # abort pic.is_a?(Array).inspect -> With "is_a?" method, you can find the type of variable
          # abort pic[1].original_filename.inspect
          # The following snippet saves the uploaded content in '#{Rails.root}/public/uploads' with a name which contains a time footprint + the original file  
          # reference: http://guides.rubyonrails.org/form_helpers.html
          #File.open(Rails.root.join('public', 'uploads', pic[1].original_filename), 'wb') do |file|
           # file.write(pic[1].read)
            #File.rename(file, 'public/uploads/' + time_footprint + pic[1].original_filename)
         # end
       
        #files_list = Dir['public/uploads/*'].to_json #get a list of all files in the {public/uploads} directory and make a JSON to pass to the server
        render json: { message: 'You have successfully uploded your images.' } #return a JSON object amd success message if uploading is successful
      end
end
