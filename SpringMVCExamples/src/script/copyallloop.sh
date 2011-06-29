source ~/.bashrc

#NEWDIR="developMode"
#GLOBALJS="TR.Global.js"
APACHE_PATH="/var/www/html"

#create directiories if not already there
mkdir -p $APACHE_PATH/css
mkdir -p $APACHE_PATH/js
mkdir -p $APACHE_PATH/img
#mkdir -p $APACHE_PATH/xml


while ["$1" == ""]
    do
		rsync -ru --exclude=/css --exclude=/img --exclude=/js web/* $APACHE_PATH
		rsync -ru web/css/* $APACHE_PATH/css
		rsync -ru web/js/* $APACHE_PATH/js
		rsync -ru web/img/* $APACHE_PATH/img
#		rsync -ru web/xml/* $APACHE_PATH/xml/$NEWDIR
		rsync -ru src/main/webapp/WEB-INF/jsp ${TOMCAT_HOME}/webapps/SpringMVCExamples/WEB-INF/


#	find $APACHE_PATH/css/$NEWDIR -type f -exec sed -i 's/@STATIC_IMAGE_SERVERNAME@/'"\/img\/$NEWDIR\/"'/g' {} \;
#	find $APACHE_PATH/css/$NEWDIR -type f -exec sed -i 's/@STATIC_XML_SERVERNAME@/'"\/xml\/$NEWDIR\/"'/g' {} \;
#	find $APACHE_PATH/css/$NEWDIR -type f -exec sed -i 's/@IMAGE_SUFFIX@/'""'/g' {} \;
#	find $APACHE_PATH/js/$NEWDIR/$GLOBALJS -type f -exec sed -i 's/@STATIC_IMAGE_SERVERNAME@/'"\/img\/$NEWDIR\/"'/g' {} \;
#	find $APACHE_PATH/js/$NEWDIR/$GLOBALJS -type f -exec sed -i 's/@STATIC_JAVASCRIPT_SERVERNAME@/'"\/js\/$NEWDIR\/"'/g' {} \;
#	find $APACHE_PATH/js/$NEWDIR/$GLOBALJS -type f -exec sed -i 's/@STATIC_CSS_SERVERNAME@/'"\/css\/$NEWDIR\/"'/g' {} \;


#	cat 	$APACHE_PATH/css/$NEWDIR/sethGrid.css $APACHE_PATH/css/$NEWDIR/elements.css $APACHE_PATH/css/$NEWDIR/layer.css $APACHE_PATH/css/$NEWDIR/containers.css $APACHE_PATH/css/$NEWDIR/icons.css   $APACHE_PATH/css/$NEWDIR/global.1.0.css $APACHE_PATH/css/$NEWDIR/modules.css $APACHE_PATH/css/$NEWDIR/custom.css > $APACHE_PATH/css/$NEWDIR/combo.css


#	cat 	$APACHE_PATH/css/$NEWDIR/sethGrid.css $APACHE_PATH/css/$NEWDIR/elements.css $APACHE_PATH/css/$NEWDIR/layer.css $APACHE_PATH/css/$NEWDIR/containers.css $APACHE_PATH/css/$NEWDIR/icons.css   $APACHE_PATH/css/$NEWDIR/global.1.0.css $APACHE_PATH/css/$NEWDIR/modules.css $APACHE_PATH/css/$NEWDIR/custom.css $APACHE_PATH/css/$NEWDIR/largeFrame.css > $APACHE_PATH/css/$NEWDIR/comboLargeFrame.css

#	cat 	$APACHE_PATH/css/$NEWDIR/sethGrid.css $APACHE_PATH/css/$NEWDIR/elements.css $APACHE_PATH/css/$NEWDIR/layer.css $APACHE_PATH/css/$NEWDIR/containers.css $APACHE_PATH/css/$NEWDIR/icons.css $APACHE_PATH/css/$NEWDIR/splash.css $APACHE_PATH/css/$NEWDIR/global.1.0.css > $APACHE_PATH/css/$NEWDIR/splashCombo.css

#	cat 	$APACHE_PATH/js/$NEWDIR/ajax/TR.Ajax.js $APACHE_PATH/js/$NEWDIR/ajax/TR.Ajax.LayerRequest.js  > $APACHE_PATH/js/$NEWDIR/ajax/TR.AjaxCombo.js


        if [ -d target/classes ] 
            then rsync -ru target/classes ${TOMCAT_HOME}/webapps/SpringMVCExamples/WEB-INF/
            else echo "target/classes not found"
        fi
    sleep 1
done
